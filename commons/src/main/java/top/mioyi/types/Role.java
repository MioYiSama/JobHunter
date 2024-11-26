package top.mioyi.types;

import java.util.Arrays;
import java.util.List;

public enum Role {
    USER,
    ADMIN,
    EMPLOYER,
    UNKNOWN;

    public static final List<Role> ALL_ROLES = Arrays.stream(Role.values()).toList();
}
