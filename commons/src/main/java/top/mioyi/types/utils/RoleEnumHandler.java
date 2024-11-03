package top.mioyi.types.utils;

import lombok.val;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import top.mioyi.types.Role;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Role.class)
public class RoleEnumHandler extends BaseTypeHandler<Role> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Role parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.name().toLowerCase());
    }

    @Override
    public Role getNullableResult(ResultSet rs, String columnName) throws SQLException {
        val name = rs.getString(columnName).toUpperCase();
        return Role.valueOf(name);
    }

    @Override
    public Role getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        val name = rs.getString(columnIndex).toUpperCase();
        return Role.valueOf(name);
    }

    @Override
    public Role getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        val name = cs.getString(columnIndex).toUpperCase();
        return Role.valueOf(name);
    }
}
