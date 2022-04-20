package com.walmart.interview.wellness.wellnessspringstarter.controller;

import com.walmart.interview.wellness.wellnessspringstarter.model.Medication;
import com.walmart.interview.wellness.wellnessspringstarter.repository.MedicationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
public class MedicationsController {
    private final MedicationRepository medicationRepository;

    public MedicationsController(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    /**
     * curl localhost:8088/medications
     * @return
     */
    @GetMapping("/medications")
    public Collection<Medication> getAllMedications() {
        return medicationRepository.findAllMedications();
    }

    /**
     * curl localhost:8088/medications/1
     * @param id
     * @return
     */
    @GetMapping("/medications/{id}")
    public Medication getMedication(@PathVariable String id) {
        Medication medication = medicationRepository.findById(id);
        if (medication == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication not found");
        }
        return medication;
    }

    /**
     * curl -X PUT -H "Content-Type: application/json" localhost:8088/medications/1 --data-binary "{ \"name\": \"Lipitor 5mg\", \"numberOfRefills\": 3 }"
     *
     * @param medication
     * @return
     */
    @PutMapping("/medications/{id}")
    public Medication updateMedication(@PathVariable String id, @RequestBody Medication medication) {
        Medication existingMedication = medicationRepository.findById(id);
        if (medication == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication not found");
        }
        existingMedication.setName(medication.getName());
        existingMedication.setNumberOfRefills(medication.getNumberOfRefills());
        medicationRepository.saveMedication(existingMedication);
        return existingMedication;
    }

    /**
     * curl -X POST -H "Content-Type: application/json" localhost:8088/medications --data-binary "{ \"name\": \"Lipitor 20mg\", \"numberOfRefills\": 3 }"
     * @param medication
     * @return
     */
    @PostMapping("/medications")
    public Medication createMedications(@RequestBody Medication medication) {
        medicationRepository.saveMedication(medication);
        return medication;
    }

    /**
     * curl -X DELETE -H "Content-Type: application/json" localhost:8088/medications/1
     * @param id
     * @return
     */
    @DeleteMapping("/medications/{id}")
    public Medication deleteMedication(@PathVariable String id) {
        Medication medication = medicationRepository.findById(id);
        if (medication == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication not found");
        }
        medicationRepository.deleteMedication(medication);
        return medication;
    }
}
