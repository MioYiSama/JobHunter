package top.mioyi.services.favorite.services;

import top.mioyi.dto.FavoriteDTO;
import top.mioyi.requests.favorite.CreateFavoriteRequest;

import java.util.List;

public interface FavoriteService {
    List<FavoriteDTO> getFavoriteList(Long userID);

    boolean createFavorite(CreateFavoriteRequest request);

    boolean deleteFavorite(Long userID, Long positionID);
}
