package top.mioyi.types;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public enum ServiceEnum {
    AUTH_SERVICE(
            "/api/v1/auth",
            Role.ALL_ROLES
    ),
    USER_SERVICE(
            "/api/v1/user",
            List.of(Role.ADMIN)
    ),
    INFO_SERVICE(
            "/api/v1/info",
            List.of(Role.USER, Role.EMPLOYER, Role.ADMIN)
    ),
    FAVORITE_SERVICE(
            "/api/v1/favorite",
            List.of(Role.USER, Role.ADMIN)
    ),
    POSITION_SERVICE(
            "/api/v1/position",
            List.of(Role.EMPLOYER, Role.ADMIN)
    ),
    SEARCH_SERVICE(
            "/api/v1/search",
            List.of(Role.USER, Role.EMPLOYER, Role.ADMIN)
    );

    private final String prefix;
    private final List<Role> allowedRoles;

    public static Optional<ServiceEnum> parseFromPath(final String path) {
        return Arrays.stream(values())
                .filter(it -> path.startsWith(it.prefix))
                .findFirst();
    }

    public boolean allow(final Role role) {
        return allowedRoles.contains(role);
    }
}
