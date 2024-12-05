package top.mioyi.services.position.services;

import top.mioyi.dto.PositionDTO;
import top.mioyi.requests.position.CreatePositionRequest;
import top.mioyi.responses.OperationResponse;
import top.mioyi.types.Education;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface PositionService {
    Optional<PositionDTO> getPositionByID(Long id);

    List<PositionDTO> getPositionByEmployerID(Long employerID);

    OperationResponse createPosition(CreatePositionRequest request);

    OperationResponse deletePositionByID(Long id);

    OperationResponse updatePositionTitle(Long id, String title);

    OperationResponse updatePositionDetailCompany(Long id, String detailCompany);

    OperationResponse updatePositionMinSalary(Long id, Integer minSalary);

    OperationResponse updatePositionMaxSalary(Long id, Integer maxSalary);

    OperationResponse updatePositionEducation(Long id, Education education);

    OperationResponse updatePositionDescription(Long id, String description);

    OperationResponse updatePositionHiringManager(Long id, String hiringManager);

    OperationResponse updatePositionLastActive(Long id, Date lastActive);

    OperationResponse updatePositionAddress(Long id, String address);

    OperationResponse updatePositionLink(Long id, String link);
}