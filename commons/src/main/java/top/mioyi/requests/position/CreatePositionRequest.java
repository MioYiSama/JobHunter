package top.mioyi.requests.position;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.mioyi.entities.Position;
import top.mioyi.types.Education;
import top.mioyi.utils.Snowflake;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "创建职位请求")
public class CreatePositionRequest {
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

    public Position getPosition() {
        return new Position(
                Snowflake.INSTANCE.nextId(),
                employerId,
                title,
                detailCompany,
                minSalary,
                maxSalary,
                education,
                description,
                hiringManager,
                lastActive,
                address,
                link
        );
    }
}
