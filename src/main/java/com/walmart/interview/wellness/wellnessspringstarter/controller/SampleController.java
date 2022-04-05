package com.walmart.interview.wellness.wellnessspringstarter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/greet")
    public String testController() {
        return "Greetings from Wellness Spring Starter!";
    }

}
