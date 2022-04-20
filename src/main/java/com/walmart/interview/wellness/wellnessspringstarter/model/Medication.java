package com.walmart.interview.wellness.wellnessspringstarter.model;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Medication {
    private String id;
    private String name;
    private Integer numberOfRefills;
    private ZonedDateTime createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfRefills() {
        return numberOfRefills;
    }

    public void setNumberOfRefills(Integer numberOfRefills) {
        this.numberOfRefills = numberOfRefills;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medication that = (Medication) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(numberOfRefills, that.numberOfRefills) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, numberOfRefills, createdAt);
    }

    @Override
    public String toString() {
        return "Medication{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", numberOfRefills=" + numberOfRefills +
                ", createdAt=" + createdAt +
                '}';
    }
}