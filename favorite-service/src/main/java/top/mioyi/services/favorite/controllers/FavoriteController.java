package top.mioyi.services.favorite.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.mioyi.dto.FavoriteDTO;
import top.mioyi.requests.favorite.CreateFavoriteRequest;
import top.mioyi.responses.OperationResponse;
import top.mioyi.services.favorite.services.FavoriteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/favorite")
@AllArgsConstructor
@Tag(name = "Favorite Controller", description = "用户收藏API")
public class FavoriteController {
    private final FavoriteService favoriteService;

    @Operation(description = "获取用户的收藏列表")
    @ApiResponse(responseCode = "200", description = "获取成功")
    @GetMapping("/")
    public ResponseEntity<List<FavoriteDTO>> getFavoriteList(@RequestParam Long userID) {
        val result = favoriteService.getFavoriteList(userID);

        return ResponseEntity.ok(result);
    }

    @Operation(description = "添加一个收藏")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "添加成功"),
            @ApiResponse(responseCode = "400", description = "添加失败")
    })
    @PostMapping("/")
    public ResponseEntity<OperationResponse> addFavorite(@RequestBody CreateFavoriteRequest request) {
        val result = favoriteService.createFavorite(request);

        if (!result) {
            return ResponseEntity.badRequest().body(new OperationResponse(false, "添加失败"));
        }

        return ResponseEntity.ok(OperationResponse.SUCCESS);
    }

    @Operation(description = "删除一个收藏")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "删除成功"),
            @ApiResponse(responseCode = "400", description = "删除失败")
    })
    @DeleteMapping("/")
    public ResponseEntity<OperationResponse> deleteFavorite(@RequestParam Long userID, @RequestParam Long positionID) {
        val result = favoriteService.deleteFavorite(userID, positionID);

        if (!result) {
            return ResponseEntity.badRequest().body(new OperationResponse(false, "删除失败"));
        }

        return ResponseEntity.ok(OperationResponse.SUCCESS);
    }
}
