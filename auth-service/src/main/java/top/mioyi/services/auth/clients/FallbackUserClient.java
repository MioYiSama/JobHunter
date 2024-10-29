package top.mioyi.services.auth.clients;

import org.springframework.stereotype.Component;
import top.mioyi.entities.User;

@Component
public class FallbackUserClient implements UserClient {
    @Override
    public User getUser() {
        return null;
    }
}
