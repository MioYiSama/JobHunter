package top.mioyi.services.user.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import top.mioyi.types.Role;

@Mapper
public interface RoleMapper {
    @Update("UPDATE user SET role = #{role} WHERE account = #{account}")
    int updateRoleByAccount(String account, Role role);
}
