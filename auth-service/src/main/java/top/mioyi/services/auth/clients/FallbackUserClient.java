package top.mioyi.services.auth.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import top.mioyi.dto.UserDTO;
import top.mioyi.responses.OperationResponse;
import top.mioyi.responses.user.GetUserResponse;

@Component
public class FallbackUserClient implements UserClient {
    private static final String ERROR_MESSAGE = "User Service运行异常";

    @Override
    public ResponseEntity<GetUserResponse> getUserByAccount(@RequestParam("account") String account) {
        return ResponseEntity.internalServerError().body(new GetUserResponse(null, ERROR_MESSAGE));
    }

    @Override
    public ResponseEntity<OperationResponse> createUser(UserDTO user) {
        return ResponseEntity.internalServerError().body(new OperationResponse(false, ERROR_MESSAGE));
    }
}
