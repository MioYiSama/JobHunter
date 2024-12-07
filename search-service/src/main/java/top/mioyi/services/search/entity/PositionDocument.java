package top.mioyi.services.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import top.mioyi.entities.Position;
import top.mioyi.types.Education;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "position")
public class PositionDocument {
    @Id
    private Long id;

    private Long employerId;
    private String title;
    private String detailCompany;
    private Integer minSalary;
    private Integer maxSalary;
    private Education education;
    private String description;
    private String hiringManager;
    private Date lastActive;
    private String address;
    private String link;

    public PositionDocument(Position position) {
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
