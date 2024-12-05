package top.mioyi.services.favorite.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mioyi.services.favorite.services.FavoriteService;

@RestController
@RequestMapping("/api/v1/favorite")
@AllArgsConstructor
@Tag(name = "Favorite Controller", description = "用户收藏API")
public class FavoriteController {
    private final FavoriteService favoriteService;


}
