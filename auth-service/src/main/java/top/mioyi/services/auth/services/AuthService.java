package top.mioyi.services.auth.services;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import top.mioyi.dto.UserDTO;
import top.mioyi.requests.auth.LoginRequest;
import top.mioyi.requests.auth.SignupRequest;
import top.mioyi.responses.auth.LoginResponse;
import top.mioyi.responses.auth.SignupResponse;
import top.mioyi.services.auth.clients.UserClient;
import top.mioyi.types.Role;

import java.util.Objects;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class AuthService {
    private final JwtService jwtService;
    private final UserClient userClient;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final Pattern passwordRegex = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9]).+$");

    public LoginResponse login(LoginRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));

        try {
            val authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getAccount(), request.getPassword())
            );

            if (authentication.isAuthenticated()) {
                val token = jwtService.generateToken(request.getAccount());
                return new LoginResponse(token, null);
            }
        } catch (AuthenticationException e) {
            return new LoginResponse(null, "认证失败: " + e.getMessage());
        }

        return new LoginResponse(null, "密码错误");
    }

    public SignupResponse signup(SignupRequest request) {
        var user = Objects.requireNonNull(userClient.getUserByAccount(request.getAccount()).getBody()).getUser();

        if (user != null) {
            return new SignupResponse(false, null, "账号已存在");
        }

        if (request.getRole() == Role.ADMIN) {
            return new SignupResponse(false, null, "无法创建管理员账户");
        }

        if (!validatePasswordComplexity(request.getPassword()))
            return new SignupResponse(false, null, "密码不够复杂（需长度≥8，同时包含数字和字母）");

        user = new UserDTO(request.getName(), request.getAccount(), passwordEncoder.encode(request.getPassword()), request.getRole());

        val response = Objects.requireNonNull(userClient.createUser(user).getBody());

        if (!response.isSuccess()) {
            return new SignupResponse(false, null, "无法创建用户: " + response.getMessage());
        }

        val token = jwtService.generateToken(request.getAccount());

        return new SignupResponse(true, token, null);
    }

    private boolean validatePasswordComplexity(String password) {
        return password.length() >= 8 && passwordRegex.matcher(password).matches();
    }
}
