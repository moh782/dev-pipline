package com.javatechie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DevopsIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevopsIntegrationApplication.class, args);
    }

    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "Zineb") String name) {
        return "<html>" +
                "<head><title>DevOps Pipeline</title></head>" +
                "<body style='background-color: #282c34; color: white; text-align: center; padding: 50px;'>" +
                "<h1>Bienvenue dans les pipeline DevOps, " + name + " 🚀</h1>" +
                "</body>" +
                "</html>";
    }
}

