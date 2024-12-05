package top.mioyi.services.user.services;

import top.mioyi.dto.UserDTO;
import top.mioyi.requests.user.CreateUserRequest;

import java.util.Optional;

public interface UserService {
    Optional<UserDTO> getUserByAccount(String account);

    Optional<Long> createUser(CreateUserRequest request);
}