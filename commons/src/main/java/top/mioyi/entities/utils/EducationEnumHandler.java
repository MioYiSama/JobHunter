package top.mioyi.entities.utils;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import top.mioyi.entities.Education;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EducationEnumHandler extends BaseTypeHandler<Education> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Education parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getValue());
    }

    @Override
    public Education getNullableResult(ResultSet rs, String columnName) throws SQLException {
        var name = rs.getString(columnName);
        return Education.parse(name);
    }

    @Override
    public Education getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        var name = rs.getString(columnIndex);
        return Education.parse(name);
    }

    @Override
    public Education getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        var name = cs.getString(columnIndex);
        return Education.parse(name);
    }
}
