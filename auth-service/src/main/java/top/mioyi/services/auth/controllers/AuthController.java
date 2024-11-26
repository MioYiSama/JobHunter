package top.mioyi.services.auth.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.mioyi.requests.auth.LoginRequest;
import top.mioyi.requests.auth.SignupRequest;
import top.mioyi.responses.auth.LoginResponse;
import top.mioyi.responses.auth.SignupResponse;
import top.mioyi.services.auth.services.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Auth Controller", description = "认证API")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @Operation(
            description = "登录"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "登录成功"),
            @ApiResponse(responseCode = "400", description = "用户不存在或密码错误")
    })
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        val response = authService.login(request);

        if (response.getToken() != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

    @Operation(
            description = "登出"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "返回Token"),
            @ApiResponse(responseCode = "400", description = "Header未携带Token；Token解析失败；账号不存在")
    })
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String authorization) {
        val result = authService.logout(authorization);

        if (result) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
            description = "注册"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "返回Token"),
            @ApiResponse(responseCode = "400", description = "用户已存在；密码不够复杂；尝试注册管理员账户")
    })
    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest request) {
        val response = authService.signup(request);

        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }
}
