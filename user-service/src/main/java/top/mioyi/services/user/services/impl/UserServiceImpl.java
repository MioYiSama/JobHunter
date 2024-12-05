package top.mioyi.services.user.services.impl;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import top.mioyi.dto.UserDTO;
import top.mioyi.requests.user.CreateUserRequest;
import top.mioyi.services.user.mappers.UserMapper;
import top.mioyi.services.user.services.RabbitMQSender;
import top.mioyi.services.user.services.UserService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RabbitMQSender rabbitMQSender;

    @Override
    @Cacheable(cacheNames = "user", key = "#account", unless = "#result.isEmpty()")
    public Optional<UserDTO> getUserByAccount(String account) {
        return userMapper.getUserByAccount(account)
                .map(UserDTO::new);
    }

    @Override
    public Optional<Long> createUser(CreateUserRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));

        val user = request.getUser();

        try {
            val result = userMapper.addUser(user);

            if (result == 0) {
                return Optional.empty();
            }

            rabbitMQSender.sendMessage(String.format("%s;%d", request.getRole().name(), user.getId()));
            return Optional.of(user.getId());
        } catch (DuplicateKeyException e) {
            return Optional.empty();
        }
    }
}