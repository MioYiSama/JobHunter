package top.mioyi.responses.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "注册响应")
public class SignupResponse {
    @Schema(description = "是否成功")
    private boolean success;

    @Schema(description = "Token")
    private String token;

    @Schema(description = "详细信息")
    private String message;
}
