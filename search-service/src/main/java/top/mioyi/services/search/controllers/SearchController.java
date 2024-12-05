package top.mioyi.services.search.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mioyi.services.search.services.SearchService;

@RestController
@RequestMapping("/api/v1/search")
@AllArgsConstructor
@Tag(name = "Search Controller", description = "职位搜索API")
public class SearchController {
    private final SearchService searchService;
}
