package com.example.shortcutservice;

import com.example.shortcutservice.links.LinkService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ShortcutserviceApplication {

    private final LinkService linkService;

    public ShortcutserviceApplication(LinkService linkService) {
        this.linkService = linkService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ShortcutserviceApplication.class, args);
    }

    @GetMapping
    public int status() {
        linkService.randomPull();
        return Thread.activeCount();
    }
}
