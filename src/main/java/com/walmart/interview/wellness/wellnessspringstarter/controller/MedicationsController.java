package com.walmart.interview.wellness.wellnessspringstarter.controller;

import com.walmart.interview.wellness.wellnessspringstarter.model.Medication;
import com.walmart.interview.wellness.wellnessspringstarter.repository.MedicationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class MedicationsController {
    private final MedicationRepository medicationRepository;

    public MedicationsController(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @GetMapping("/greet")
    public String testController() {
        return "Greetings from Wellness Spring Starter!";
    }
}
