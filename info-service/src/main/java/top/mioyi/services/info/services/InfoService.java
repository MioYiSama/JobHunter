package top.mioyi.services.info.services;

import top.mioyi.dto.EmployerInfoDTO;
import top.mioyi.dto.UserInfoDTO;
import top.mioyi.responses.OperationResponse;
import top.mioyi.types.Education;

import java.util.Optional;

public interface InfoService {
    Optional<UserInfoDTO> getUserInfo(Long id);

    Optional<EmployerInfoDTO> getEmployerInfo(Long id);

    OperationResponse updateUserBirthYear(Long userID, String birthYear);

    OperationResponse updateUserMinExpectedSalary(Long userID, String minExpectedSalary);

    OperationResponse updateUserMaxExpectedSalary(Long userID, String maxExpectedSalary);

    OperationResponse updateUserEducation(Long userID, Education education);

    OperationResponse updateUserSchool(Long userID, String school);

    OperationResponse updateUserMajor(Long userID, String major);

    OperationResponse updateEmployerCompany(Long employerID, String company);
}
