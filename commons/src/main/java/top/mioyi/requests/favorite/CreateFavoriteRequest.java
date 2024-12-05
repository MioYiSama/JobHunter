package top.mioyi.requests.favorite;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.mioyi.entities.Favorite;
import top.mioyi.utils.Snowflake;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "创建收藏请求")
public class CreateFavoriteRequest {
    @Schema(description = "用户ID")
    private Long userId;

    @Schema(description = "职位ID")
    private Long positionId;

    public Favorite getFavorite() {
        return new Favorite(Snowflake.INSTANCE.nextId(), userId, positionId);
    }
}
