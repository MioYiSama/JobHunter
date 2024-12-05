package top.mioyi.responses.info;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.mioyi.dto.EmployerInfoDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "获取雇员信息的响应")
public class GetEmployerInfoResponse {
    @Schema(description = "雇员信息")
    private EmployerInfoDTO info;

    @Schema(description = "详细信息")
    private String message;
}
