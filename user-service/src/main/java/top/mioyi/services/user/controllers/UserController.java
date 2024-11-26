package top.mioyi.services.user.controllers;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.mioyi.dto.UserDTO;
import top.mioyi.responses.user.CreateUserResponse;
import top.mioyi.responses.user.GetUserResponse;
import top.mioyi.services.user.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<GetUserResponse> getUserByAccount(@RequestParam("account") String account) {
        val user = userService.getUserByAccount(account);

        //noinspection OptionalIsPresent
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body(new GetUserResponse(null, "未找到用户"));
        }

        return ResponseEntity.ok(new GetUserResponse(user.get(), null));
    }

    @PostMapping("/")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody UserDTO user) {
        if (!userService.createUser(user)) {
            return ResponseEntity.badRequest().body(new CreateUserResponse(false, "用户创建失败"));
        }

        return ResponseEntity.ok(new CreateUserResponse(true, null));
    }
}
