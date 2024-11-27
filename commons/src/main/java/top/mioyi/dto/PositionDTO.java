package top.mioyi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.mioyi.entities.Position;
import top.mioyi.types.Education;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "职位DTO")
public class PositionDTO {
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "雇主ID")
    private Long employerId;

    @Schema(description = "职位名称")
    private String title;

    @Schema(description = "公司名称")
    private String detailCompany;

    @Schema(description = "最低薪资")
    private Integer minSalary;

    @Schema(description = "最高薪资")
    private Integer maxSalary;

    @Schema(description = "学历要求")
    private Education education;

    @Schema(description = "职位描述")
    private String description;

    @Schema(description = "招聘负责人")
    private String hiringManager;

    @Schema(description = "最后活跃时间")
    private Date lastActive;

    @Schema(description = "工作地点")
    private String address;

    @Schema(description = "职位链接")
    private String link;

    public PositionDTO(Position position) {
        this.id = position.getId();
        this.employerId = position.getEmployerId();
        this.title = position.getTitle();
        this.detailCompany = position.getDetailCompany();
        this.minSalary = position.getMinSalary();
        this.maxSalary = position.getMaxSalary();
        this.education = position.getEducation();
        this.description = position.getDescription();
        this.hiringManager = position.getHiringManager();
        this.lastActive = position.getLastActive();
        this.address = position.getAddress();
        this.link = position.getLink();
    }
}
