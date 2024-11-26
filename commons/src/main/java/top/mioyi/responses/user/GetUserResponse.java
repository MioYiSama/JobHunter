package top.mioyi.responses.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.mioyi.dto.UserDTO;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "获取用户的响应")
public class GetUserResponse implements Serializable {
    @Schema(description = "用户数据")
    private UserDTO user;

    @Schema(description = "详细信息")
    private String message;
}
