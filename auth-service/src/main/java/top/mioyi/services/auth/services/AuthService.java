package top.mioyi.services.auth.services;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import top.mioyi.requests.auth.LoginRequest;
import top.mioyi.requests.auth.SignupRequest;
import top.mioyi.requests.user.CreateUserRequest;
import top.mioyi.responses.auth.LoginResponse;
import top.mioyi.responses.auth.SignupResponse;
import top.mioyi.services.auth.clients.UserClient;
import top.mioyi.types.Role;

import java.util.Objects;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class AuthService {
    private static final String PREFIX = "Bearer ";

    private final JwtService jwtService;
    private final UserClient userClient;
    private final PasswordEncoder passwordEncoder;
    private final Pattern passwordRegex = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9]).+$");

    public LoginResponse login(LoginRequest request) {
        val response = userClient.getUserByAccount(request.getAccount());

        if (response.getStatusCode() != HttpStatus.OK) {
            return new LoginResponse(null, "用户不存在");
        }

        @SuppressWarnings("DataFlowIssue")
        val user = response.getBody().getUser();
        val password = user.getPassword();

        if (!passwordEncoder.matches(request.getPassword(), password)) {
            return new LoginResponse(null, "密码错误");
        }

        val token = jwtService.generateToken(request.getAccount());
        return new LoginResponse(token, null);

    }

    public SignupResponse signup(SignupRequest request) {
        val user = Objects.requireNonNull(userClient.getUserByAccount(request.getAccount()).getBody()).getUser();

        if (user != null) {
            return new SignupResponse(false, null, "账号已存在");
        }

        if (request.getRole() == Role.ADMIN) {
            return new SignupResponse(false, null, "无法创建管理员账户");
        }

        if (!validatePasswordComplexity(request.getPassword()))
            return new SignupResponse(false, null, "密码不够复杂（需长度≥8，同时包含数字和字母）");

        val createUserRequest = new CreateUserRequest(request.getName(), request.getAccount(), request.getPassword(), request.getRole());

        val response = Objects.requireNonNull(userClient.createUser(createUserRequest).getBody());

        if (!response.isSuccess()) {
            return new SignupResponse(false, null, "无法创建用户: " + response.getMessage());
        }

        val token = jwtService.generateToken(request.getAccount());

        return new SignupResponse(true, token, null);
    }

    public boolean logout(String header) {
        if (!header.startsWith(PREFIX)) {
            return false;
        }

        val token = header.substring(PREFIX.length());

        return jwtService.invalidateJwt(token);
    }

    private boolean validatePasswordComplexity(String password) {
        return password.length() >= 8 && passwordRegex.matcher(password).matches();
    }
}
