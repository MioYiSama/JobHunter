package top.mioyi.services.auth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import top.mioyi.entities.User;

@FeignClient(value = "gateway-server", fallback = FallbackUserClient.class)
public interface UserClient {
    @GetMapping("/api/v1/user/get")
    User getUser();
}
