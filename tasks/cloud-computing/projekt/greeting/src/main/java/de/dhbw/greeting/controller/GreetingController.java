package de.dhbw.greeting.controller;

import de.dhbw.greeting.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public String greeting(
            @RequestParam(value = "name", defaultValue = "Welt") String name,
            @RequestParam(value = "apikey", defaultValue = "") String apikey) {
        return greetingService.greet(name);
    }
}
