package top.mioyi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.mioyi.entities.EmployerInfo;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "雇员DTO")
public class EmployerInfoDTO {
    @Schema(description = "信息ID")
    private Long id;

    @Schema(description = "雇员ID")
    private Long employerId;

    @Schema(description = "公司名")
    private String company;

    public EmployerInfoDTO(EmployerInfo info) {
        this.id = info.getId();
        this.employerId = info.getEmployerId();
        this.company = info.getCompany();
    }
}
