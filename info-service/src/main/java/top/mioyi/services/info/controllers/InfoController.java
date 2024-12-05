package top.mioyi.services.info.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mioyi.services.info.services.InfoService;

@RestController
@RequestMapping("/api/v1/info")
@AllArgsConstructor
@Tag(name = "Info Controller", description = "用户信息API")
public class InfoController {
    private final InfoService infoService;
}
