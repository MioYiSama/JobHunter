package top.mioyi.services.position.services;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import top.mioyi.entities.Position;
import top.mioyi.responses.OperationResponse;
import top.mioyi.responses.position.GetPositionResponse;
import top.mioyi.services.position.mappers.PositionMapper;
import top.mioyi.types.Education;

import java.sql.Date;

@Service
@AllArgsConstructor
public class PositionService {
    private final PositionMapper positionMapper;

    public GetPositionResponse getPositionByID(Long id) {
        val position = positionMapper.getPositionByID(id);

        if (position.isEmpty()) {
            return new GetPositionResponse(null, "职位不存在");
        }

        return new GetPositionResponse(position.get(), null);
    }

    public GetPositionResponse getPositionByEmployerID(Long employerID) {
        val position = positionMapper.getPositionByEmployerID(employerID);

        if (position.isEmpty()) {
            return new GetPositionResponse(null, "职位不存在");
        }

        return new GetPositionResponse(position.get(), null);
    }

    public OperationResponse createPosition(Position position) {
        val result = positionMapper.addPosition(position);

        if (result == 0) {
            return new OperationResponse(false, "职位创建失败");
        }

        return OperationResponse.SUCCESS;
    }

    public OperationResponse deletePositionByID(Long id) {
        val result = positionMapper.deletePositionByID(id);

        if (!result) {
            return new OperationResponse(false, "职位删除失败");
        }

        return OperationResponse.SUCCESS;
    }

    public OperationResponse updatePositionTitle(Long id, String title) {
        val result = positionMapper.updatePositionTitle(id, title);

        if (!result) {
            return new OperationResponse(false, "更新职位的名称失败");
        }

        return OperationResponse.SUCCESS;
    }

    public OperationResponse updatePositionDetailCompany(Long id, String detailCompany) {
        val result = positionMapper.updatePositionDetailCompany(id, detailCompany);

        if (!result) {
            return new OperationResponse(false, "更新职位的公司名称失败");
        }

        return OperationResponse.SUCCESS;
    }

    public OperationResponse updatePositionMinSalary(Long id, Integer minSalary) {
        val result = positionMapper.updatePositionMinSalary(id, minSalary);

        if (!result) {
            return new OperationResponse(false, "更新职位的最低薪资失败");
        }

        return OperationResponse.SUCCESS;
    }

    public OperationResponse updatePositionMaxSalary(Long id, Integer maxSalary) {
        val result = positionMapper.updatePositionMaxSalary(id, maxSalary);

        if (!result) {
            return new OperationResponse(false, "更新职位的最高薪资失败");
        }

        return OperationResponse.SUCCESS;
    }

    public OperationResponse updatePositionEducation(Long id, Education education) {
        val result = positionMapper.updatePositionEducation(id, education);

        if (!result) {
            return new OperationResponse(false, "更新职位的学历要求失败");
        }

        return OperationResponse.SUCCESS;
    }

    public OperationResponse updatePositionDescription(Long id, String description) {
        val result = positionMapper.updatePositionDescription(id, description);

        if (!result) {
            return new OperationResponse(false, "更新职位的描述失败");
        }

        return OperationResponse.SUCCESS;
    }

    public OperationResponse updatePositionHiringManager(Long id, String hiringManager) {
        val result = positionMapper.updatePositionHiringManager(id, hiringManager);

        if (!result) {
            return new OperationResponse(false, "更新职位的招聘负责人失败");
        }

        return OperationResponse.SUCCESS;
    }

    public OperationResponse updatePositionLastActive(Long id, Date lastActive) {
        val result = positionMapper.updatePositionLastActive(id, lastActive);

        if (!result) {
            return new OperationResponse(false, "更新职位的最后活跃时间失败");
        }

        return OperationResponse.SUCCESS;
    }

    public OperationResponse updatePositionAddress(Long id, String address) {
        val result = positionMapper.updatePositionAddress(id, address);

        if (!result) {
            return new OperationResponse(false, "更新职位的工作地点失败");
        }

        return OperationResponse.SUCCESS;
    }

    public OperationResponse updatePositionLink(Long id, String link) {
        val result = positionMapper.updatePositionLink(id, link);

        if (!result) {
            return new OperationResponse(false, "更新职位的链接失败");
        }

        return OperationResponse.SUCCESS;
    }
}
