package top.mioyi.services.user.services;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import top.mioyi.dto.UserDTO;
import top.mioyi.services.user.mappers.UserMapper;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Cacheable(cacheNames = "user", key = "#account", unless = "#result == null")
    public Optional<UserDTO> getUserByAccount(String account) {
        return userMapper.getUserByAccount(account)
                .map(UserDTO::new);
    }

    public boolean createUser(UserDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        try {
            val result = userMapper.insertUser(user.toUser());
            return result != 0;
        } catch (DuplicateKeyException e) {
            return false;
        }
    }
}
