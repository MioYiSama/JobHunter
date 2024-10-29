package top.mioyi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * 职位
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    /**
     * 职位ID
     */
    private Integer id;

    /**
     * 公司名称(可为分部)
     */
    private String detailCompany;

    /**
     * 职位名称
     */
    private String title;

    /**
     * 薪资范围
     */
    private String salary;

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

    /**
     * 招聘者ID
     */
    private Integer eid;
}
