package top.mioyi.services.auth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import top.mioyi.dto.UserDTO;
import top.mioyi.responses.OperationResponse;
import top.mioyi.responses.user.GetUserResponse;

@Primary
@FeignClient(
        value = "user-service",
        path = "/api/v1/user",
        fallback = FallbackUserClient.class
)
public interface UserClient {
    @GetMapping("/")
    ResponseEntity<GetUserResponse> getUserByAccount(@RequestParam("account") String account);

    @PostMapping("/")
    ResponseEntity<OperationResponse> createUser(@RequestBody UserDTO user);
}
