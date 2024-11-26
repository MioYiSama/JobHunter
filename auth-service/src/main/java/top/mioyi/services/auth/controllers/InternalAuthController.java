package top.mioyi.services.auth.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mioyi.services.auth.clients.UserClient;
import top.mioyi.services.auth.services.JwtService;
import top.mioyi.types.Role;

@RestController
@RequestMapping("/api/v1/internal/auth")
@Tag(name = "Internal Auth Controller", description = "为Gateway提供的API")
@AllArgsConstructor
public class InternalAuthController {
    private final JwtService jwtService;
    private final UserClient userClient;

    @Operation(
            description = "解析Token并返回对应的Role"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "返回Role"),
            @ApiResponse(responseCode = "400", description = "Token解析失败或User不存在")
    })
    @GetMapping("/token/resolve")
    public ResponseEntity<Role> resolveToken(
            @Parameter(description = "Token") String token
    ) {
        val account = jwtService.resolveJwt(token);

        if (account.isPresent()) {
            val response = userClient.getUserByAccount(account.get());

            if (response.getStatusCode() == HttpStatus.OK) {
                @SuppressWarnings("DataFlowIssue")
                val user = response.getBody().getUser();

                return ResponseEntity.ok(user.getRole());
            }
        }

        return ResponseEntity.badRequest().body(Role.UNKNOWN);
    }
}
