package com.walmart.interview.wellness.wellnessspringstarter.repository;

class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
