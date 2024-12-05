package top.mioyi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.mioyi.entities.UserInfo;
import top.mioyi.types.Education;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "用户信息DTO")
public class UserInfoDTO {
    @Schema(description = "信息ID")
    private Long id;

    @Schema(description = "用户ID")
    private Long userId;

    @Schema(description = "出生年份")
    private Short birthYear;

    @Schema(description = "最低期望工资")
    private Integer minExpectedSalary;

    @Schema(description = "最高期望工资")
    private Integer maxExpectedSalary;

    @Schema(description = "最高学历")
    private Education education;

    @Schema(description = "学校")
    private String school;

    @Schema(description = "专业")
    private String major;

    public UserInfoDTO(UserInfo info) {
        this.id = info.getId();
        this.userId = info.getUserId();
        this.birthYear = info.getBirthYear();
        this.minExpectedSalary = info.getMinExpectedSalary();
        this.maxExpectedSalary = info.getMaxExpectedSalary();
        this.education = info.getEducation();
        this.school = info.getSchool();
        this.major = info.getMajor();
    }
}
