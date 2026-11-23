package de.dhbw.greeting.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Value("${greeting.text:Hallo}")
    private String text;

    @Override
    public String greet(String name) {
        return text + " " + name;
    }
}
