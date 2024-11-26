package top.mioyi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.mioyi.entities.User;
import top.mioyi.types.Role;
import top.mioyi.utils.Snowflake;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "用户DTO")
public class UserDTO implements Serializable {
    @Schema(description = "用户名")
    private String name;

    @Schema(description = "账号")
    private String account;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "身份")
    private Role role;

    public UserDTO(User user) {
        this.name = user.getName();
        this.account = user.getAccount();
        this.password = user.getPassword();
        this.role = user.getRole();
    }

    public User toUser() {
        return new User(Snowflake.INSTANCE.nextId(), name, account, password, role);
    }
}
