package top.mioyi.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "数据操作结果")
public class OperationResponse {
    public static final OperationResponse SUCCESS = new OperationResponse(true, null);

    @Schema(description = "是否成功")
    private boolean success;

    @Schema(description = "详细信息")
    private String message;
}
