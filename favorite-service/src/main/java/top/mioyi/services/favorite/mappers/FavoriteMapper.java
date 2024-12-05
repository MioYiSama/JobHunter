package top.mioyi.services.favorite.mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.mioyi.entities.Favorite;

import java.util.List;

@Mapper
public interface FavoriteMapper {
    @Select("SELECT * FROM favorite WHERE user_id = #{userId}")
    List<Favorite> getFavoriteListByUserID(Long userId);

    @Insert("INSERT INTO favorite VALUES (#{id}, #{userId}, #{positionId})")
    boolean insertFavorite(Favorite favorite);

    @Delete("DELETE FROM favorite WHERE user_id = #{userId} AND position_id = #{positionId}")
    boolean deleteFavorite(Long userId, Long positionId);
}
