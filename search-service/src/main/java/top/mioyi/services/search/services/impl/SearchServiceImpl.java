package top.mioyi.services.search.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.mioyi.services.search.entity.PositionDocument;
import top.mioyi.services.search.repos.PositionRepository;
import top.mioyi.services.search.services.SearchService;
import top.mioyi.types.Education;

import java.sql.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final PositionRepository positionRepository;

    @Override
    public List<PositionDocument> searchByEmployerId(Long employerId, Pageable pageable) {
        return positionRepository.findPositionDocumentByEmployerId(employerId, pageable);
    }

    @Override
    public List<PositionDocument> searchByTitle(String title, Pageable pageable) {
        return positionRepository.findPositionDocumentByTitle(title, pageable);
    }

    @Override
    public List<PositionDocument> searchByDetailCompany(String detailCompany, Pageable pageable) {
        return positionRepository.findPositionDocumentByDetailCompany(detailCompany, pageable);
    }

    @Override
    public List<PositionDocument> searchByMinSalary(Integer minSalary, Pageable pageable) {
        return positionRepository.findPositionDocumentByMinSalary(minSalary, pageable);
    }

    @Override
    public List<PositionDocument> searchByMaxSalary(Integer maxSalary, Pageable pageable) {
        return positionRepository.findPositionDocumentByMaxSalary(maxSalary, pageable);
    }

    @Override
    public List<PositionDocument> searchByEducation(Education education, Pageable pageable) {
        return positionRepository.findPositionDocumentByEducation(education, pageable);
    }

    @Override
    public List<PositionDocument> searchByDescription(String description, Pageable pageable) {
        return positionRepository.findPositionDocumentByDescription(description, pageable);
    }

    @Override
    public List<PositionDocument> searchByHiringManager(String hiringManager, Pageable pageable) {
        return positionRepository.findPositionDocumentByHiringManager(hiringManager, pageable);
    }

    @Override
    public List<PositionDocument> searchByLastActive(Date lastActive, Pageable pageable) {
        return positionRepository.findPositionDocumentByLastActive(lastActive, pageable);
    }

    @Override
    public List<PositionDocument> searchByAddress(String address, Pageable pageable) {
        return positionRepository.findPositionDocumentByAddress(address, pageable);
    }

    @Override
    public List<PositionDocument> searchByLink(String link, Pageable pageable) {
        return positionRepository.findPositionDocumentByLink(link, pageable);
    }
}
