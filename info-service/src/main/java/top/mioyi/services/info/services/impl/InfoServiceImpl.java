package top.mioyi.services.info.services.impl;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.mioyi.dto.EmployerInfoDTO;
import top.mioyi.dto.UserInfoDTO;
import top.mioyi.responses.OperationResponse;
import top.mioyi.services.info.mappers.InfoMapper;
import top.mioyi.services.info.services.InfoService;
import top.mioyi.types.Education;

import java.util.Optional;

@Service
@AllArgsConstructor
public class InfoServiceImpl implements InfoService {
    private final InfoMapper infoMapper;

    @Override
    @Cacheable(cacheNames = "userInfo", key = "#id", unless = "#result.isEmpty()")
    public Optional<UserInfoDTO> getUserInfo(Long id) {
        val info = infoMapper.getUserInfoById(id);

        if (info.isEmpty()) {
            return Optional.empty();
        } else {
            return info.map(UserInfoDTO::new);
        }
    }

    @Override
    @Cacheable(cacheNames = "employerInfo", key = "#id", unless = "#result.isEmpty()")
    public Optional<EmployerInfoDTO> getEmployerInfo(Long id) {
        val info = infoMapper.getEmployerInfoById(id);

        if (info.isEmpty()) {
            return Optional.empty();
        } else {
            return info.map(EmployerInfoDTO::new);
        }
    }

    @CacheEvict(cacheNames = {"userInfo"}, condition = "#result.success")
    @Override
    public OperationResponse updateUserBirthYear(Long userID, String birthYear) {
        val result = infoMapper.updateUserBirthYear(userID, birthYear);

        if (!result) {
            return new OperationResponse(false, "更新用户出生年份失败");
        }

        return OperationResponse.SUCCESS;
    }

    @CacheEvict(cacheNames = {"userInfo"}, condition = "#result.success")
    @Override
    public OperationResponse updateUserMinExpectedSalary(Long userID, String minExpectedSalary) {
        val result = infoMapper.updateUserMinExpectedSalary(userID, minExpectedSalary);

        if (!result) {
            return new OperationResponse(false, "更新用户最低期望薪资失败");
        }

        return OperationResponse.SUCCESS;
    }

    @CacheEvict(cacheNames = {"userInfo"}, condition = "#result.success")
    @Override
    public OperationResponse updateUserMaxExpectedSalary(Long userID, String maxExpectedSalary) {
        val result = infoMapper.updateUserMaxExpectedSalary(userID, maxExpectedSalary);

        if (!result) {
            return new OperationResponse(false, "更新用户最高期望薪资失败");
        }

        return OperationResponse.SUCCESS;
    }

    @CacheEvict(cacheNames = {"userInfo"}, condition = "#result.success")
    @Override
    public OperationResponse updateUserEducation(Long userID, Education education) {
        val result = infoMapper.updateUserEducation(userID, education);

        if (!result) {
            return new OperationResponse(false, "更新用户学历失败");
        }

        return OperationResponse.SUCCESS;
    }

    @CacheEvict(cacheNames = {"userInfo"}, condition = "#result.success")
    @Override
    public OperationResponse updateUserSchool(Long userID, String school) {
        val result = infoMapper.updateUserSchool(userID, school);

        if (!result) {
            return new OperationResponse(false, "更新用户学校失败");
        }

        return OperationResponse.SUCCESS;
    }

    @CacheEvict(cacheNames = {"userInfo"}, condition = "#result.success")
    @Override
    public OperationResponse updateUserMajor(Long userID, String major) {
        val result = infoMapper.updateUserMajor(userID, major);

        if (!result) {
            return new OperationResponse(false, "更新用户专业失败");
        }

        return OperationResponse.SUCCESS;
    }


    @Override
    @CacheEvict(cacheNames = {"employerInfo"}, condition = "#result.success")
    public OperationResponse updateEmployerCompany(Long employerID, String company) {
        val result = infoMapper.updateEmployerCompany(employerID, company);

        if (!result) {
            return new OperationResponse(false, "更新雇员公司失败");
        }

        return OperationResponse.SUCCESS;
    }
}
