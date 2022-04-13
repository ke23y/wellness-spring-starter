package com.walmart.interview.wellness.wellnessspringstarter.repository;

import com.walmart.interview.wellness.wellnessspringstarter.model.Medication;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MedicationRepository {
    private final Map<String, Medication> medicationsById;

    public MedicationRepository() {
        this.medicationsById = new HashMap<>();
    }
}
