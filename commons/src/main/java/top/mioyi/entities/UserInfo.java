package top.mioyi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import top.mioyi.types.Education;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @NonNull
    private Long id;

    @NonNull
    private Long userId;

    /**
     * 出生年份
     */
    private Short birthYear;

    /**
     * 最低期望工资
     */
    private Integer minExpectedSalary;

    /**
     * 最高期望工资
     */
    private Integer maxExpectedSalary;

    /**
     * 最高学历
     */
    private Education education;

    /**
     * 学校
     */
    private String school;

    /**
     * 专业
     */
    private String major;
}