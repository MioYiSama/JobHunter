package top.mioyi.services.position.mappers;

import org.apache.ibatis.annotations.*;
import top.mioyi.entities.Position;
import top.mioyi.types.Education;

import java.sql.Date;
import java.util.Optional;

@Mapper
public interface PositionMapper {
    @Select("SELECT * FROM position WHERE id = #{id}")
    Optional<Position> getPositionByID(Long id);

    @Select("SELECT * FROM position WHERE employer_id = #{employerID}")
    Optional<Position> getPositionByEmployerID(Long employerID);

    @Insert("INSERT INTO position VALUES (#{id}, #{employerId}, #{title}, #{detailCompany}, #{minSalary}, #{maxSalary}, #{education}, #{description}, #{hiringManager}, #{lastActive}, #{address}, #{link})")
    int addPosition(Position position);

    @Delete("DELETE FROM position WHERE id = #{id}")
    boolean deletePositionByID(Long id);

    @Update("UPDATE position SET title = #{title} WHERE id = #{id}")
    boolean updatePositionTitle(Long id, String title);

    @Update("UPDATE position SET detail_company = #{detailCompany} WHERE id = #{id}")
    boolean updatePositionDetailCompany(Long id, String detailCompany);

    @Update("UPDATE position SET min_salary = #{minSalary} WHERE id = #{id}")
    boolean updatePositionMinSalary(Long id, Integer minSalary);

    @Update("UPDATE position SET max_salary = #{maxSalary} WHERE id = #{id}")
    boolean updatePositionMaxSalary(Long id, Integer maxSalary);

    @Update("UPDATE position SET education = #{education} WHERE id = #{id}")
    boolean updatePositionEducation(Long id, Education education);

    @Update("UPDATE position SET description = #{description} WHERE id = #{id}")
    boolean updatePositionDescription(Long id, String description);

    @Update("UPDATE position SET hiring_manager = #{hiringManager} WHERE id = #{id}")
    boolean updatePositionHiringManager(Long id, String hiringManager);

    @Update("UPDATE position SET last_active = #{lastActive} WHERE id = #{id}")
    boolean updatePositionLastActive(Long id, Date lastActive);

    @Update("UPDATE position SET address = #{address} WHERE id = #{id}")
    boolean updatePositionAddress(Long id, String address);

    @Update("UPDATE position SET link = #{link} WHERE id = #{id}")
    boolean updatePositionLink(Long id, String link);
}
