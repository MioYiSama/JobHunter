package top.mioyi.services.user.services;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import top.mioyi.dto.UserDTO;
import top.mioyi.requests.user.CreateUserRequest;
import top.mioyi.services.user.mappers.UserMapper;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Cacheable(cacheNames = "user", key = "#account", unless = "#result.isEmpty()")
    public Optional<UserDTO> getUserByAccount(String account) {
        return userMapper.getUserByAccount(account)
                .map(UserDTO::new);
    }

    public boolean createUser(CreateUserRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));

        try {
            val result = userMapper.addUser(request.getUser());
            return result != 0;
        } catch (DuplicateKeyException e) {
            return false;
        }
    }
}
