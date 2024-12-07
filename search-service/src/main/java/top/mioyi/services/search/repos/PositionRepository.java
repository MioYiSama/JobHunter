package top.mioyi.services.search.repos;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import top.mioyi.services.search.entity.PositionDocument;
import top.mioyi.types.Education;

import java.sql.Date;
import java.util.List;

@Repository
public interface PositionRepository extends ElasticsearchRepository<PositionDocument, Long> {
    List<PositionDocument> findPositionDocumentByEmployerId(Long employerId, Pageable pageable);

    List<PositionDocument> findPositionDocumentByTitle(String title, Pageable pageable);

    List<PositionDocument> findPositionDocumentByDetailCompany(String detailCompany, Pageable pageable);

    List<PositionDocument> findPositionDocumentByMinSalary(Integer minSalary, Pageable pageable);

    List<PositionDocument> findPositionDocumentByMaxSalary(Integer maxSalary, Pageable pageable);

    List<PositionDocument> findPositionDocumentByEducation(Education education, Pageable pageable);

    List<PositionDocument> findPositionDocumentByDescription(String description, Pageable pageable);

    List<PositionDocument> findPositionDocumentByHiringManager(String hiringManager, Pageable pageable);

    List<PositionDocument> findPositionDocumentByLastActive(Date lastActive, Pageable pageable);

    List<PositionDocument> findPositionDocumentByAddress(String address, Pageable pageable);

    List<PositionDocument> findPositionDocumentByLink(String link, Pageable pageable);
}
