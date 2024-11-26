package top.mioyi.requests.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.mioyi.types.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "注册请求")
public class SignupRequest {
    @Schema(description = "用户名")
    private String name;

    @Schema(description = "账号")
    private String account;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "身份（不得为ADMIN）")
    private Role role;
}
