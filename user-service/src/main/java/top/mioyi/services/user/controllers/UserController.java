package top.mioyi.services.user.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.mioyi.dto.UserDTO;
import top.mioyi.responses.OperationResponse;
import top.mioyi.responses.user.GetUserResponse;
import top.mioyi.services.user.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
@Tag(name = "User Controller", description = "用户管理API")
public class UserController {
    private UserService userService;

    @Operation(
            description = "通过账号获取用户"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "获取成功"),
            @ApiResponse(responseCode = "400", description = "未找到用户")
    })
    @GetMapping("/")
    public ResponseEntity<GetUserResponse> getUserByAccount(@RequestParam("account") String account) {
        val user = userService.getUserByAccount(account);

        //noinspection OptionalIsPresent
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body(new GetUserResponse(null, "未找到用户"));
        }

        return ResponseEntity.ok(new GetUserResponse(user.get(), null));
    }

    @Operation(
            description = "创建用户"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "创建成功"),
            @ApiResponse(responseCode = "400", description = "用户创建失败")
    })
    @PostMapping("/")
    public ResponseEntity<OperationResponse> createUser(@RequestBody UserDTO user) {
        if (!userService.createUser(user)) {
            return ResponseEntity.badRequest().body(new OperationResponse(false, "用户创建失败"));
        }

        return ResponseEntity.ok(OperationResponse.SUCCESS);
    }
}
