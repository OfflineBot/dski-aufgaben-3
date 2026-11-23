package de.dhbw.greeting.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    private final Environment environment;

    @Value("${greeting.text:Hallo}")
    private String text;

    @Value("${demo.version:0.0.1}")
    private String version;

    public InfoController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/info")
    public String info() {
        String[] profiles = environment.getActiveProfiles();
        return "profile=" + (profiles.length == 0 ? "default" : String.join(",", profiles))
                + "\ngreeting.text=" + text
                + "\ndemo.version=" + version
                + "\nhostname=" + System.getenv().getOrDefault("HOSTNAME", "unbekannt");
    }
}
