package top.mioyi.services.auth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import top.mioyi.dto.UserDTO;
import top.mioyi.responses.user.CreateUserResponse;
import top.mioyi.responses.user.GetUserResponse;
import top.mioyi.services.auth.configurations.FeignConfiguration;

@Primary
@FeignClient(value = "user-service", path = "/api/v1/user", fallback = FallbackUserClient.class, configuration = FeignConfiguration.class)
public interface UserClient {
    @GetMapping("/")
    ResponseEntity<GetUserResponse> getUserByAccount(String account);

    @PostMapping("/")
    ResponseEntity<CreateUserResponse> createUser(@RequestBody UserDTO user);
}
