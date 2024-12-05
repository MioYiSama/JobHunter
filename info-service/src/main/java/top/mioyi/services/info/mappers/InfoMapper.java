package top.mioyi.services.info.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.mioyi.entities.EmployerInfo;
import top.mioyi.entities.UserInfo;
import top.mioyi.types.Education;

import java.util.Optional;

@Mapper
public interface InfoMapper {
    @Select("SELECT * FROM user_info WHERE id = #{id}")
    Optional<UserInfo> getUserInfoById(Long id);

    @Select("SELECT * FROM employer_info WHERE id = #{id}")
    Optional<EmployerInfo> getEmployerInfoById(Long id);

    @Insert("INSERT INTO user_info VALUES (#{id}, #{user_id}, #{birth_year}, #{min_expected_salary}, #{max_expected_salary}, #{education}, #{school}, #{major})")
    void insertUserInfo(UserInfo userInfo);

    @Insert("INSERT INTO employer_info VALUES (#{id}, #{employer_id}, #{company})")
    void insertEmployerInfo(EmployerInfo employerInfo);

    @Update("UPDATE user_info SET birth_year = #{birthYear} WHERE user_id = #{userID}")
    boolean updateUserBirthYear(Long userID, String birthYear);

    @Update("UPDATE user_info SET min_expected_salary = #{minExpectedSalary} WHERE user_id = #{userID}")
    boolean updateUserMinExpectedSalary(Long userID, String minExpectedSalary);

    @Update("UPDATE user_info SET max_expected_salary = #{maxExpectedSalary} WHERE user_id = #{userID}")
    boolean updateUserMaxExpectedSalary(Long userID, String maxExpectedSalary);

    @Update("UPDATE user_info SET education = #{education} WHERE user_id = #{userID}")
    boolean updateUserEducation(Long userID, Education education);

    @Update("UPDATE user_info SET school = #{school} WHERE user_id = #{userID}")
    boolean updateUserSchool(Long userID, String school);

    @Update("UPDATE user_info SET major = #{major} WHERE user_id = #{userID}")
    boolean updateUserMajor(Long userID, String major);

    @Update("UPDATE employer_info SET company = #{company} WHERE employer_id = #{employerID}")
    boolean updateEmployerCompany(Long employerID, String company);
}
