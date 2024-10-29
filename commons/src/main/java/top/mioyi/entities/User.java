package top.mioyi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 出生年份
     */
    private Short birthYear;

    /**
     * 最低期望工资
     */
    private String minExpectedSalary;

    /**
     * 最高期望工资
     */
    private String maxExpectedSalary;

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
