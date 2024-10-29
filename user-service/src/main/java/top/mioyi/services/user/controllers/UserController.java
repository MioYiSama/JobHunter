package top.mioyi.services.user.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mioyi.entities.User;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @GetMapping("/get")
    public User getUser() {
        return new User();
    }
}
