package top.mioyi.responses.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "登录响应")
public class LoginResponse {
    @Schema(description = "Token")
    private String token;

    @Schema(description = "详细信息")
    private String message;
}
