package com.walmart.interview.wellness.wellnessspringstarter.repository;

import com.walmart.interview.wellness.wellnessspringstarter.model.Medication;

import java.util.HashMap;
import java.util.Map;

public final class RepositoryFactory {
    private static RepositoryFactory repository;

    private final Map<String, Medication> inMemoryRepo;


    private RepositoryFactory(Map<String, Medication> inMemoryRepo) {
        this.inMemoryRepo = inMemoryRepo;
    }

    public static RepositoryFactory repositoryFactory() {
        if (repository == null) {
            repository = new RepositoryFactory(new HashMap<>());
        }
        return repository;
    }

    public Map<String, Medication> getInMemoryRepo() {
        return inMemoryRepo;
    }
}
