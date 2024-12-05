package top.mioyi.services.info.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.mioyi.responses.OperationResponse;
import top.mioyi.responses.info.GetEmployerInfoResponse;
import top.mioyi.responses.info.GetUserInfoResponse;
import top.mioyi.services.info.services.InfoService;
import top.mioyi.types.Education;

@RestController
@RequestMapping("/api/v1/info")
@AllArgsConstructor
@Tag(name = "Info Controller", description = "用户信息API")
public class InfoController {
    private final InfoService infoService;

    @Operation(description = "根据用户ID获取信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "获取成功"),
            @ApiResponse(responseCode = "400", description = "未找到用户")
    })
    @GetMapping("/user")
    public ResponseEntity<GetUserInfoResponse> getUserInfo(Long id) {
        val info = infoService.getUserInfo(id);

        if (info.isEmpty()) {
            return ResponseEntity.badRequest().body(new GetUserInfoResponse(null, "未找到用户"));
        } else {
            return ResponseEntity.ok().body(new GetUserInfoResponse(info.get(), null));
        }
    }

    @Operation(description = "根据雇主ID获取信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "获取成功"),
            @ApiResponse(responseCode = "400", description = "未找到雇员")
    })
    @GetMapping("/employer")
    public ResponseEntity<GetEmployerInfoResponse> getEmployerInfo(Long id) {
        val info = infoService.getEmployerInfo(id);

        if (info.isEmpty()) {
            return ResponseEntity.badRequest().body(new GetEmployerInfoResponse(null, "未找到雇员"));
        } else {
            return ResponseEntity.ok().body(new GetEmployerInfoResponse(info.get(), null));
        }
    }
    @Operation(description = "更新用户出生年份")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "更新失败，用户不存在或其他错误")
    })
    @PostMapping("/user/birthYear")
    public ResponseEntity<OperationResponse> updateUserBirthYear(@RequestParam Long userID, @RequestParam String birthYear) {
        OperationResponse response = infoService.updateUserBirthYear(userID, birthYear);
        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    @Operation(description = "更新用户最低期望薪资")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "更新失败，用户不存在或其他错误")
    })
    @PostMapping("/user/minExpectedSalary")
    public ResponseEntity<OperationResponse> updateUserMinExpectedSalary(@RequestParam Long userID, @RequestParam String minExpectedSalary) {
        OperationResponse response = infoService.updateUserMinExpectedSalary(userID, minExpectedSalary);
        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    @Operation(description = "更新用户最高期望薪资")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "更新失败，用户不存在或其他错误")
    })
    @PostMapping("/user/maxExpectedSalary")
    public ResponseEntity<OperationResponse> updateUserMaxExpectedSalary(@RequestParam Long userID, @RequestParam String maxExpectedSalary) {
        OperationResponse response = infoService.updateUserMaxExpectedSalary(userID, maxExpectedSalary);
        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    @Operation(description = "更新用户学历")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "更新失败，用户不存在或其他错误")
    })
    @PostMapping("/user/education")
    public ResponseEntity<OperationResponse> updateUserEducation(@RequestParam Long userID, @RequestBody Education education) {
        OperationResponse response = infoService.updateUserEducation(userID, education);
        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    @Operation(description = "更新用户学校")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "更新失败，用户不存在或其他错误")
    })
    @PostMapping("/user/school")
    public ResponseEntity<OperationResponse> updateUserSchool(@RequestParam Long userID, @RequestParam String school) {
        OperationResponse response = infoService.updateUserSchool(userID, school);
        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    @Operation(description = "更新用户专业")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "更新失败，用户不存在或其他错误")
    })
    @PostMapping("/user/major")
    public ResponseEntity<OperationResponse> updateUserMajor(@RequestParam Long userID, @RequestParam String major) {
        OperationResponse response = infoService.updateUserMajor(userID, major);
        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    @Operation(description = "更新雇员公司")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "更新失败，雇员不存在或其他错误")
    })
    @PostMapping("/employer/company")
    public ResponseEntity<OperationResponse> updateEmployerCompany(@RequestParam Long employerID, @RequestParam String company) {
        OperationResponse response = infoService.updateEmployerCompany(employerID, company);
        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }
}
