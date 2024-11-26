package top.mioyi.services.user.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.mioyi.services.user.services.RoleService;
import top.mioyi.types.Role;

@RestController
@RequestMapping("/api/v1/user/role")
@AllArgsConstructor
@Tag(name = "Role Controller", description = "用户身份API")
public class RoleController {
    private final RoleService roleService;

    @Operation(
            description = "修改对应账号的用户身份"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "修改成功"),
            @ApiResponse(responseCode = "400", description = "未找到用户")
    })
    @CacheEvict(cacheNames = "user", key = "#account")
    @PostMapping("/")
    public ResponseEntity<Void> setRole(
            @RequestParam("account") String account,
            @RequestParam("role") Role role
    ) {
        val result = roleService.setRole(account, role);

        if (result) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
