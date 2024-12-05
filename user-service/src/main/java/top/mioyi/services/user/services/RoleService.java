package top.mioyi.services.user.services;

import top.mioyi.types.Role;

public interface RoleService {
    boolean setRole(String account, Role role);
}