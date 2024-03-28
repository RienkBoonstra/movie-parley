package com.movieparley.backend.chat.adapter.in;

import com.movieparley.backend.chat.adapter.configuration.AppProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/probe")
public class ManagementController {

    private final AppProperties appProperties;

    public ManagementController(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @GetMapping("/dead_or_alive")
    public String deadOrAlive() {
        return "Oh, god still alive!";
    }

    @GetMapping("/version")
    public String version() {
        return appProperties.version();
    }
}
