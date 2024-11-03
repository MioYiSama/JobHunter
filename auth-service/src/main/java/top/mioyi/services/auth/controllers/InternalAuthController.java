package top.mioyi.services.auth.controllers;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mioyi.services.auth.clients.UserClient;
import top.mioyi.services.auth.services.JwtService;
import top.mioyi.types.Role;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/internal/auth")
@AllArgsConstructor
public class InternalAuthController {
    private final JwtService jwtService;
    private final UserClient userClient;

    @GetMapping("/token/resolve")
    public ResponseEntity<Role> resolveToken(String token) {
        val account = jwtService.resolveJwt(token);

        if (account.isPresent()) {
            val user = Objects.requireNonNull(userClient.getUserByAccount(account.get()).getBody()).getUser();

            if (user != null) {
                return ResponseEntity.ok(user.getRole());
            }
        }

        return ResponseEntity.badRequest().body(null);
    }
}
