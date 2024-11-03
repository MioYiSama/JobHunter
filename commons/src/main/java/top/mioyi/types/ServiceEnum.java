package top.mioyi.types;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public enum ServiceEnum {
    USER_SERVICE(
            "/api/v1/user",
            List.of(Role.ADMIN)
    );

    private final String prefix;
    private final List<Role> allowedRoles;

    public static Optional<ServiceEnum> parseFromPath(final String path) {
        return Arrays.stream(values())
                .filter(it -> it.prefix.equals(path))
                .findFirst();
    }

    public boolean allow(final Role role) {
        return allowedRoles.contains(role);
    }
}
