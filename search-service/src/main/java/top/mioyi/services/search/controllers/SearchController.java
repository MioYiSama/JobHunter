package top.mioyi.services.search.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.mioyi.services.search.entity.PositionDocument;
import top.mioyi.services.search.services.SearchService;
import top.mioyi.types.Education;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
@AllArgsConstructor
@Tag(name = "Search Controller", description = "职位搜索API")
public class SearchController {
    private final SearchService searchService;

    @GetMapping("/employer")
    @Operation(description = "根据雇主ID搜索职位")
    @ApiResponse(responseCode = "200", description = "搜索成功")
    public ResponseEntity<List<PositionDocument>> searchByEmployerId(
            @RequestParam Long employerId,
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(searchService.searchByEmployerId(employerId, pageable));
    }

    @GetMapping("/title")
    @Operation(description = "根据职位标题搜索")
    @ApiResponse(responseCode = "200", description = "搜索成功")
    public ResponseEntity<List<PositionDocument>> searchByTitle(
            @RequestParam String title,
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(searchService.searchByTitle(title, pageable));
    }

    @GetMapping("/company")
    @Operation(description = "根据公司名称搜索职位")
    @ApiResponse(responseCode = "200", description = "搜索成功")
    public ResponseEntity<List<PositionDocument>> searchByDetailCompany(
            @RequestParam String detailCompany,
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(searchService.searchByDetailCompany(detailCompany, pageable));
    }

    @GetMapping("/min-salary")
    @Operation(description = "根据最低薪资搜索职位")
    @ApiResponse(responseCode = "200", description = "搜索成功")
    public ResponseEntity<List<PositionDocument>> searchByMinSalary(
            @RequestParam Integer minSalary,
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(searchService.searchByMinSalary(minSalary, pageable));
    }

    @GetMapping("/max-salary")
    @Operation(description = "根据最高薪资搜索职位")
    @ApiResponse(responseCode = "200", description = "搜索成功")
    public ResponseEntity<List<PositionDocument>> searchByMaxSalary(
            @RequestParam Integer maxSalary,
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(searchService.searchByMaxSalary(maxSalary, pageable));
    }

    @GetMapping("/education")
    @Operation(description = "根据学历要求搜索职位")
    @ApiResponse(responseCode = "200", description = "搜索成功")
    public ResponseEntity<List<PositionDocument>> searchByEducation(
            @RequestParam Education education,
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(searchService.searchByEducation(education, pageable));
    }

    @GetMapping("/description")
    @Operation(description = "根据职位描述搜索职位")
    @ApiResponse(responseCode = "200", description = "搜索成功")
    public ResponseEntity<List<PositionDocument>> searchByDescription(
            @RequestParam String description,
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(searchService.searchByDescription(description, pageable));
    }

    @GetMapping("/manager")
    @Operation(description = "根据招聘经理搜索职位")
    @ApiResponse(responseCode = "200", description = "搜索成功")
    public ResponseEntity<List<PositionDocument>> searchByHiringManager(
            @RequestParam String hiringManager,
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(searchService.searchByHiringManager(hiringManager, pageable));
    }

    @GetMapping("/last-active")
    @Operation(description = "根据最后活跃日期搜索职位")
    @ApiResponse(responseCode = "200", description = "搜索成功")
    public ResponseEntity<List<PositionDocument>> searchByLastActive(
            @RequestParam Date lastActive,
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(searchService.searchByLastActive(lastActive, pageable));
    }

    @GetMapping("/address")
    @Operation(description = "根据地址搜索职位")
    @ApiResponse(responseCode = "200", description = "搜索成功")
    public ResponseEntity<List<PositionDocument>> searchByAddress(
            @RequestParam String address,
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(searchService.searchByAddress(address, pageable));
    }

    @GetMapping("/link")
    @Operation(description = "根据职位链接搜索职位")
    @ApiResponse(responseCode = "200", description = "搜索成功")
    public ResponseEntity<List<PositionDocument>> searchByLink(
            @RequestParam String link,
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(searchService.searchByLink(link, pageable));
    }
}
