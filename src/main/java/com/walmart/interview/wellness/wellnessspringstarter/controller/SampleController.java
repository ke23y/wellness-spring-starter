package com.walmart.interview.wellness.wellnessspringstarter.controller;

import com.walmart.interview.wellness.wellnessspringstarter.model.Medication;
import com.walmart.interview.wellness.wellnessspringstarter.model.MedicationRequest;
import com.walmart.interview.wellness.wellnessspringstarter.model.MedicationResponse;
import com.walmart.interview.wellness.wellnessspringstarter.repository.RepositoryFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class SampleController {
    private Map<String, Medication> repository;

    public SampleController() {
        repository = RepositoryFactory.repositoryFactory().getInMemoryRepo();
    }

    @GetMapping("/greet")
    public String testController() {
        return "Greetings from Wellness Spring Starter!";
    }

    @GetMapping("/medications")
    public ResponseEntity<MedicationResponse> getMedication(@RequestParam String id) {
        MedicationResponse response = new MedicationResponse();
        if (repository.containsKey(id)) {
            response.setMedication(repository.get(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
         response = MedicationResponse.builder()
                .message("Medication can not be found").build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/medications")
    public ResponseEntity<MedicationResponse> addMedications(@RequestBody MedicationRequest medications) {

        List<Medication> medicationList = medications.getMedications();
        for (Medication medication : medicationList) {
            if (medication.getId() != null) {
                repository.put(medication.getId(), medication);
            }
        }

        MedicationResponse response = MedicationResponse.builder()
                .message("New medications added successfully").build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/medications")
    public ResponseEntity<MedicationResponse> updateMedications(@RequestBody MedicationRequest medications) {

        List<Medication> medicationList = medications.getMedications();
        for (Medication medication : medicationList) {
            if (medication.getId() == null || !repository.containsKey(medication.getId())) {
                MedicationResponse response = MedicationResponse.builder().message("Invalid medication id").build();
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            repository.replace(medication.getId(), medication);
        }

        MedicationResponse response = MedicationResponse.builder()
                .message("Medications updated successfully").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/medications")
    public ResponseEntity<MedicationResponse> deleteMedication(@RequestParam String id) {
        MedicationResponse response = new MedicationResponse();
        if (repository.containsKey(id)) {
            response.setMedication(repository.get(id));
            repository.remove(id);
            response.setMessage("Medication successfully removed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response = MedicationResponse.builder()
                .message("Medication can not be deleted").build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
