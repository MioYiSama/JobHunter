package top.mioyi.requests.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "登录请求")
public class LoginRequest {
    @Schema(description = "账号")
    private String account;

    @Schema(description = "密码")
    private String password;
}
