package top.mioyi.responses.position;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.mioyi.dto.PositionDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "获取职位的响应")
public class GetPositionListResponse {
    @Schema(description = "职位数据")
    private List<PositionDTO> position;

    @Schema(description = "详细信息")
    private String message;
}
