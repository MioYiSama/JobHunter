package top.mioyi.dto;

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
public class UserDTO implements Serializable {
    private String name;
    private String account;
    private String password;
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
