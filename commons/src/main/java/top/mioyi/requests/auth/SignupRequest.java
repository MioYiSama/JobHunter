package top.mioyi.requests.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.mioyi.types.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String name;
    private String account;
    private String password;
    private Role role;
}
