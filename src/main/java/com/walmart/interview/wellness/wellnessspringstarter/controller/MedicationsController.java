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

    @GetMapping("/medications")
    public Collection<Medication> getAllMedications() {
        return medicationRepository.findAllMedications();
    }

    @GetMapping("/medications/{id}")
    public Medication getMedication(@PathVariable String id) {
        Medication medication = medicationRepository.findById(id);
        if (medication == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication not found");
        }
        return medication;
    }

    /**
     * curl -X PUT -H "Content-Type: application/json" localhost:8088/medications --data-binary "{ \"id\": \"1\", \"name\": \"Lipitor 20mg\" }" | jq
     *
     * @param medication
     * @return
     */
    @PutMapping("/medications")
    public Medication updateMedication(@RequestBody Medication medication) {
        medicationRepository.saveMedication(medication);
        return medication;
    }

    /**
     * curl -X POST -H "Content-Type: application/json" localhost:8088/medications --data-binary "{ \"name\": \"Lipitor 20mg\" }" | jq
     * @param medication
     * @return
     */
    @PostMapping("/medications")
    public Medication createMedications(@RequestBody Medication medication) {
        medicationRepository.saveMedication(medication);
        return medication;
    }

    /**
     * curl -X DELETE -H "Content-Type: application/json" localhost:8088/medications/1 | jq
     * @param id
     * @return
     */
    @DeleteMapping("/medications/{id}")
    public Medication deleteMedication(@PathVariable String id) {
        Medication medication = medicationRepository.findById(id);
        if (medication == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication not found");
        }
        return medication;
    }


}
