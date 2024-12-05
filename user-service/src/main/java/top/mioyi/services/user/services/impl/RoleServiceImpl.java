package top.mioyi.services.user.services.impl;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import top.mioyi.services.user.mappers.RoleMapper;
import top.mioyi.services.user.services.RoleService;
import top.mioyi.types.Role;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleMapper roleMapper;

    @Override
    public boolean setRole(String account, Role role) {
        val result = roleMapper.updateRoleByAccount(account, role);
        return result != 0;
    }
}