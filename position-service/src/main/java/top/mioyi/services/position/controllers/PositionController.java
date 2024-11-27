package top.mioyi.services.position.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.mioyi.requests.position.CreatePositionRequest;
import top.mioyi.responses.OperationResponse;
import top.mioyi.responses.position.GetPositionListResponse;
import top.mioyi.responses.position.GetPositionResponse;
import top.mioyi.services.position.services.PositionService;
import top.mioyi.types.Education;

import java.sql.Date;

@RestController
@RequestMapping("/api/v1/position")
@AllArgsConstructor
@Tag(name = "Position Controller", description = "职位管理API")
public class PositionController {
    private final PositionService positionService;

    @Operation(description = "根据职位ID获取职位信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "获取成功"),
            @ApiResponse(responseCode = "400", description = "未找到对应职位")
    })
    @GetMapping("/id")
    public ResponseEntity<GetPositionResponse> getPositionByID(@RequestParam long id) {
        val position = positionService.getPositionByID(id);

        if (position.isEmpty()) {
            return ResponseEntity.badRequest().body(new GetPositionResponse(null, "职位创建失败"));
        }

        return ResponseEntity.ok(new GetPositionResponse(position.get(), null));
    }

    @Operation(description = "根据雇主ID获取职位列表")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "获取成功"),
            @ApiResponse(responseCode = "400", description = "未找到对应职位")
    })
    @GetMapping("/employer_id")
    public ResponseEntity<GetPositionListResponse> getPositionByEmployerID(@RequestParam long employerID) {
        val positionList = positionService.getPositionByEmployerID(employerID);

        return ResponseEntity.ok(new GetPositionListResponse(positionList, null));
    }

    @Operation(description = "创建新的职位")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "创建成功"),
            @ApiResponse(responseCode = "400", description = "职位创建失败")
    })
    @PostMapping("/")
    public ResponseEntity<OperationResponse> createPosition(@RequestBody CreatePositionRequest position) {
        val response = positionService.createPosition(position);

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @Operation(description = "根据职位ID删除职位")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "删除成功"),
            @ApiResponse(responseCode = "400", description = "删除失败，职位不存在或其他错误")
    })
    @DeleteMapping("/")
    public ResponseEntity<OperationResponse> deletePositionByID(@RequestParam long id) {
        val response = positionService.deletePositionByID(id);

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @Operation(description = "更新职位名称")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "更新失败，职位不存在或其他错误")
    })
    @PostMapping("/title")
    public ResponseEntity<OperationResponse> updatePositionTitle(@RequestParam Long id, @RequestParam String title) {
        val response = positionService.updatePositionTitle(id, title);

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @Operation(description = "更新公司名称")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "更新失败，职位不存在或其他错误")
    })
    @PostMapping("/detailCompany")
    public ResponseEntity<OperationResponse> updatePositionDetailCompany(@RequestParam Long id, @RequestParam String detailCompany) {
        val response = positionService.updatePositionDetailCompany(id, detailCompany);

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @Operation(description = "更新最低薪资")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "更新失败，职位不存在或其他错误")
    })
    @PostMapping("/minSalary")
    public ResponseEntity<OperationResponse> updatePositionMinSalary(@RequestParam Long id, @RequestParam Integer minSalary) {
        val response = positionService.updatePositionMinSalary(id, minSalary);

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @Operation(description = "更新最高薪资")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "更新失败，职位不存在或其他错误")
    })
    @PostMapping("/maxSalary")
    public ResponseEntity<OperationResponse> updatePositionMaxSalary(@RequestParam Long id, @RequestParam Integer maxSalary) {
        val response = positionService.updatePositionMaxSalary(id, maxSalary);

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @Operation(description = "更新学历要求")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "更新失败，职位不存在或其他错误")
    })
    @PostMapping("/education")
    public ResponseEntity<OperationResponse> updatePositionEducation(@RequestParam Long id, @RequestParam Education education) {
        val response = positionService.updatePositionEducation(id, education);

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @Operation(description = "更新职位描述")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "更新失败，职位不存在或其他错误")
    })
    @PostMapping("/description")
    public ResponseEntity<OperationResponse> updatePositionDescription(@RequestParam Long id, @RequestParam String description) {
        val response = positionService.updatePositionDescription(id, description);

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @Operation(description = "更新招聘负责人")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "更新失败，职位不存在或其他错误")
    })
    @PostMapping("/hiringManager")
    public ResponseEntity<OperationResponse> updatePositionHiringManager(@RequestParam Long id, @RequestParam String hiringManager) {
        val response = positionService.updatePositionHiringManager(id, hiringManager);

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @Operation(description = "更新最后活跃时间")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "更新失败，职位不存在或其他错误")
    })
    @PostMapping("/lastActive")
    public ResponseEntity<OperationResponse> updatePositionLastActive(
            @RequestParam Long id,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date lastActive) {
        val response = positionService.updatePositionLastActive(id, lastActive);

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @Operation(description = "更新工作地点")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "更新失败，职位不存在或其他错误")
    })
    @PostMapping("/address")
    public ResponseEntity<OperationResponse> updatePositionAddress(@RequestParam Long id, @RequestParam String address) {
        val response = positionService.updatePositionAddress(id, address);

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @Operation(description = "更新职位链接")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "更新失败，职位不存在或其他错误")
    })
    @PostMapping("/link")
    public ResponseEntity<OperationResponse> updatePositionLink(@RequestParam Long id, @RequestParam String link) {
        val response = positionService.updatePositionLink(id, link);

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }
}
