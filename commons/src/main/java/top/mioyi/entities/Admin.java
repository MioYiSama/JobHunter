package top.mioyi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理员
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    /**
     * 管理员ID
     */
    private Long id;

    /**
     * 管理员姓名
     */
    private String name;

    /**
     * 管理员密码
     */
    private String password;

}
