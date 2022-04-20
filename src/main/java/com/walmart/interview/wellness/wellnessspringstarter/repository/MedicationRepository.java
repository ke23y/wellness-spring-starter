package com.walmart.interview.wellness.wellnessspringstarter.repository;

import com.walmart.interview.wellness.wellnessspringstarter.model.Medication;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.*;

/**
 * This is a JPA-style "Repository" implementation. It defines the standard methods
 * that a real JPA `CRUDRepository` would provide: `findById`, `save`, and `delete`.
 */
@Component
public class MedicationRepository {

    /**
     * Uses a Map to easily store Medications by their ID
     */
    private final Map<String, Medication> medicationsById;

    public MedicationRepository() {
        this.medicationsById = new HashMap<>();
    }

    public Medication findById(String id) {
        return medicationsById.get(id);
    }

    /**
     * This creates or updates a Medication record, based on whether the Medication is persisted or not.
     * This check is done by checking whether the record has an ID. If this were real JPA, that check
     * may be done by some internal mechanism (Hibernate may use an internal flag on the implementation
     * of the model, for example).
     *
     * This method throws EntityNotFound exception if trying to update a Medication that does not
     * exist, mirroring the behavior of JPA CRUDRepository.
     *
     * @param medication
     */
    public void save(Medication medication) {
        if (medication.getId() != null) {
            if (medicationsById.containsKey(medication.getId())) {
                medicationsById.put(medication.getId(),  medication);
            } else {
                throw new EntityNotFoundException("Medication not found");
            }
        } else {
            // If we're creating a new Medication, auto-generate a unique ID
            String id = UUID.randomUUID().toString();
            medication.setId(id);
            // And set the createdAt timestamp
            medication.setCreatedAt(ZonedDateTime.now());
            medicationsById.put(id, medication);
        }
    }

    public void delete(Medication medication) {
        medicationsById.remove(medication.getId());
    }

    public Collection<Medication> findAllMedications() {
        return medicationsById.values();
    }
}
