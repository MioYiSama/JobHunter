package top.mioyi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import top.mioyi.types.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NonNull
    private Long id;

    /**
     * 用户名
     */
    @NonNull
    private String name;

    /**
     * 账号
     */
    @NonNull
    private String account;

    /**
     * 密码
     */
    @NonNull
    private String password;

    /**
     * 身份
     */
    @NonNull
    private Role role;
}