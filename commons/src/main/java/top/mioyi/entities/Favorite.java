package top.mioyi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 收藏
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Favorite {
    /**
     * 收藏ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 职位ID
     */
    private Integer positionId;
}
