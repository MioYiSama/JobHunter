package top.mioyi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.mioyi.entities.Favorite;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "收藏DTO")
public class FavoriteDTO {
    @Schema(description = "收藏ID")
    private Long id;

    @Schema(description = "用户ID")
    private Long userId;

    @Schema(description = "职位ID")
    private Long positionId;

    public FavoriteDTO(Favorite favorite) {
        this.id = favorite.getId();
        this.userId = favorite.getUserId();
        this.positionId = favorite.getPositionId();
    }
}
