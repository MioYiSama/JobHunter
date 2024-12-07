package top.mioyi.services.search.services;

import org.springframework.data.domain.Pageable;
import top.mioyi.services.search.entity.PositionDocument;
import top.mioyi.types.Education;

import java.sql.Date;
import java.util.List;

public interface SearchService {
    List<PositionDocument> searchByEmployerId(Long employerId, Pageable pageable);

    List<PositionDocument> searchByTitle(String title, Pageable pageable);

    List<PositionDocument> searchByDetailCompany(String detailCompany, Pageable pageable);

    List<PositionDocument> searchByMinSalary(Integer minSalary, Pageable pageable);

    List<PositionDocument> searchByMaxSalary(Integer maxSalary, Pageable pageable);

    List<PositionDocument> searchByEducation(Education education, Pageable pageable);

    List<PositionDocument> searchByDescription(String description, Pageable pageable);

    List<PositionDocument> searchByHiringManager(String hiringManager, Pageable pageable);

    List<PositionDocument> searchByLastActive(Date lastActive, Pageable pageable);

    List<PositionDocument> searchByAddress(String address, Pageable pageable);

    List<PositionDocument> searchByLink(String link, Pageable pageable);
}
