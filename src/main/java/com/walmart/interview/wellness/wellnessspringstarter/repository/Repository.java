package com.walmart.interview.wellness.wellnessspringstarter.repository;

import com.walmart.interview.wellness.wellnessspringstarter.model.Medication;

import java.util.HashMap;
import java.util.Map;

public final class Repository {
    private static Repository repository;

    private final Map<String, Medication> inMemoryRepo;


    private Repository(Map<String, Medication> inMemoryRepo) {
        this.inMemoryRepo = inMemoryRepo;
    }

    public static Repository repositoryFactory() {
        if (repository == null) {
            repository = new Repository(new HashMap<>());
        }
        return repository;
    }

    public Map<String, Medication> getInMemoryRepo() {
        return inMemoryRepo;
    }
}
