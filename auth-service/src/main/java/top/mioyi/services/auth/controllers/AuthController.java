package top.mioyi.services.auth.controllers;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mioyi.entities.User;
import top.mioyi.services.auth.clients.UserClient;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Resource
    UserClient userClient;

    @GetMapping("/get")
    public User getUser() {
        return userClient.getUser();
    }
}
