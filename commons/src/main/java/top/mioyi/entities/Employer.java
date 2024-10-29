package top.mioyi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 招聘者
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employer {
    /**
     * 招聘者编号
     */
    private Long id;

    /**
     * 招聘者姓名
     */
    private String name;

    /**
     * 招聘者密码
     */
    private String password;

    /**
     * 公司名称
     */
    private String company;
}
