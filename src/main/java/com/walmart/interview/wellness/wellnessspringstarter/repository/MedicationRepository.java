package com.walmart.interview.wellness.wellnessspringstarter.repository;

import com.walmart.interview.wellness.wellnessspringstarter.model.Medication;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.*;

@Component
public class MedicationRepository {
    private final Map<String, Medication> medicationsById;

    public MedicationRepository() {
        this.medicationsById = new HashMap<>();
    }

    public Medication findById(String id) {
        return medicationsById.get(id);
    }

    public void saveMedication(Medication medication) {
        if (medication.getId() != null) {
            if (medicationsById.containsKey(medication.getId())) {
                medicationsById.put(medication.getId(),  medication);
            } else {
                throw new EntityNotFoundException("Medication not found");
            }
        } else {
            String id = UUID.randomUUID().toString();
            medication.setId(id);
            medication.setCreatedAt(ZonedDateTime.now());
            medicationsById.put(id, medication);
        }
    }

    public void deleteMedication(Medication medication) {
        medicationsById.remove(medication.getId());
    }

    public Collection<Medication> findAllMedications() {
        return medicationsById.values();
    }
}
