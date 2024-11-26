package top.mioyi.responses.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "创建用户的响应")
public class CreateUserResponse {
    @Schema(description = "是否成功")
    private boolean success;

    @Schema(description = "详细信息")
    private String message;
}
