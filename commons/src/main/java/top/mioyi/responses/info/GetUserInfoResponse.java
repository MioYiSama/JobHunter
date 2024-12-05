package top.mioyi.responses.info;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.mioyi.dto.UserInfoDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "获取用户信息的响应")
public class GetUserInfoResponse {
    @Schema(description = "用户信息")
    private UserInfoDTO info;

    @Schema(description = "详细信息")
    private String message;
}
