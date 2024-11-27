package top.mioyi.services.user.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.mioyi.entities.User;

import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE account = #{account}")
    Optional<User> getUserByAccount(String account);

    @Insert("INSERT INTO user VALUES (#{id}, #{name}, #{account}, #{password}, #{role})")
    int addUser(User user);
}
