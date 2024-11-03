package top.mioyi.services.auth.services;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.mioyi.services.auth.clients.UserClient;

import java.util.Objects;

@Service
@AllArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        val user = Objects.requireNonNull(userClient.getUserByAccount(username).getBody()).getUser();

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return User.builder()
                .username(user.getAccount())
                .password(user.getPassword())
                .build();
    }
}
