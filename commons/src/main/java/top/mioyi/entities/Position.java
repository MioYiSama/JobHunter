package top.mioyi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.mioyi.types.Education;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    /**
     * ID
     */
    private Long id;

    /**
     * 雇主ID
     */
    private Long employerId;

    /**
     * 职位名称
     */
    private String title;

    /**
     * 公司名称
     */
    private String detailCompany;

    /**
     * 最低薪资
     */
    private Integer minSalary;

    /**
     * 最高薪资
     */
    private Integer maxSalary;

    /**
     * 学历要求
     */
    private Education education;

    /**
     * 职位描述
     */
    private String description;

    /**
     * 招聘负责人
     */
    private String hiringManager;

    /**
     * 最后活跃时间
     */
    private Date lastActive;

    /**
     * 工作地点
     */
    private String address;

    /**
     * 职位链接
     */
    private String link;
}