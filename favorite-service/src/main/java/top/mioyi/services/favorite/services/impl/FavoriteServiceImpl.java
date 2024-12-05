package top.mioyi.services.favorite.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.mioyi.dto.FavoriteDTO;
import top.mioyi.requests.favorite.CreateFavoriteRequest;
import top.mioyi.services.favorite.mappers.FavoriteMapper;
import top.mioyi.services.favorite.services.FavoriteService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteMapper favoriteMapper;

    @Cacheable(cacheNames = "favorites", key = "userID")
    @Override
    public List<FavoriteDTO> getFavoriteList(Long userID) {
        return favoriteMapper.getFavoriteListByUserID(userID)
                .stream()
                .map(FavoriteDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean createFavorite(CreateFavoriteRequest request) {
        return favoriteMapper.insertFavorite(request.getFavorite());
    }

    @Override
    public boolean deleteFavorite(Long userID, Long positionID) {
        return favoriteMapper.deleteFavorite(userID, positionID);
    }
}
