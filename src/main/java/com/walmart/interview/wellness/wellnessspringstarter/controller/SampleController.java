package com.walmart.interview.wellness.wellnessspringstarter.controller;

import com.walmart.interview.wellness.wellnessspringstarter.model.Medication;
import com.walmart.interview.wellness.wellnessspringstarter.model.MedicationResponse;
import com.walmart.interview.wellness.wellnessspringstarter.repository.MedicationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class SampleController {
    private final MedicationRepository medicationRepository;

    public SampleController(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @GetMapping("/greet")
    public String testController() {
        return "Greetings from Wellness Spring Starter!";
    }

    @GetMapping("/medications")
    public ResponseEntity<Collection<Medication>> getAllMedications() {
        Collection<Medication> medications = medicationRepository.findAllMedications();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(medications);
    }

    @GetMapping("/medications/{id}")
    public ResponseEntity<MedicationResponse> getMedication(@PathVariable String id) {
        MedicationResponse response = new MedicationResponse();
        Medication medication = medicationRepository.findById(id);
        if (medication != null) {
            response.setMedication(medication);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
         response = MedicationResponse.builder()
                .message("Medication can not be found").build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * curl -X PUT -H "Content-Type: application/json" localhost:8088/medications --data-binary "{ \"id\": \"1\", \"name\": \"Lipitor 20mg\" }" | jq
     *
     * @param medication
     * @return
     */
    @PutMapping("/medications")
    public ResponseEntity<MedicationResponse> updateMedication(@RequestBody Medication medication) {
        medicationRepository.saveMedication(medication);
        MedicationResponse response = MedicationResponse.builder()
                .message("Medication updated successfully").build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * curl -X POST -H "Content-Type: application/json" localhost:8088/medications --data-binary "{ \"name\": \"Lipitor 20mg\" }" | jq
     * @param medication
     * @return
     */
    @PostMapping("/medications")
    public ResponseEntity<MedicationResponse> createMedications(@RequestBody Medication medication) {
        medicationRepository.saveMedication(medication);
        MedicationResponse response = MedicationResponse.builder()
                .message("Medication created successfully")
                .medication(medication)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * curl -X DELETE -H "Content-Type: application/json" localhost:8088/medications/1 | jq
     * @param id
     * @return
     */
    @DeleteMapping("/medications/{id}")
    public ResponseEntity<MedicationResponse> deleteMedication(@PathVariable String id) {
        MedicationResponse response = new MedicationResponse();
        Medication medication = medicationRepository.findById(id);
        if (medication != null) {
            medicationRepository.deleteMedication(medication);
            response.setMedication(medication);
            response.setMessage("Medication successfully removed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_MODIFIED);
    }

}
