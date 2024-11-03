package top.mioyi.services.auth.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import top.mioyi.dto.UserDTO;
import top.mioyi.responses.user.CreateUserResponse;
import top.mioyi.responses.user.GetUserResponse;

@Component
public class FallbackUserClient implements UserClient {
    private static final String ERROR_MESSAGE = "User Service运行异常";

    @Override
    public ResponseEntity<GetUserResponse> getUserByAccount(String account) {
        return ResponseEntity.internalServerError().body(new GetUserResponse(null, ERROR_MESSAGE));
    }

    @Override
    public ResponseEntity<CreateUserResponse> createUser(UserDTO user) {
        return ResponseEntity.internalServerError().body(new CreateUserResponse(false, ERROR_MESSAGE));
    }
}
