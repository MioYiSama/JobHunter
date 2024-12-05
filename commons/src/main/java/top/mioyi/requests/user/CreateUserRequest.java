package top.mioyi.requests.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.mioyi.entities.User;
import top.mioyi.types.Role;
import top.mioyi.utils.Snowflake;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "创建用户请求")
public class CreateUserRequest {
    @Schema(description = "用户名")
    private String name;

    @Schema(description = "账号")
    private String account;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "身份（USER或EMPLOYER）")
    private Role role;

    public User getUser() {
        return new User(Snowflake.INSTANCE.nextId(), name, account, password, role);
    }
}
