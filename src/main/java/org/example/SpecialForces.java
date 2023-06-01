package org.example;

import Exceptions.SoldierNotFoundException;
import Interface.Isalute;

import java.util.List;

import static org.example.Aircraft.LOGGER;

public abstract class SpecialForces extends Soldier implements Isalute {
    protected String specialty;
    public SpecialForces() {
        this.specialty = null;
    }
    public SpecialForces(String name, int age, String rank,String department,
                         String location, String specialty) {
        super(name, age, rank, department,location);
        this.specialty = specialty;
    }

    public abstract void specialMission();
    @Override
    public int hashCode() {
        return this.getAge();
    }
    @Override
    public boolean equals(Object obj) {

        SpecialForces that = (SpecialForces) obj; //down casting
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        return this.getAge() == that.getAge() &&
                this.getName().equals(that.getName()) &&
                this.getRank().equals(that.getRank()) &&
                this.specialty.equals(that.specialty);
    }
    public void validateSoldier() throws SoldierNotFoundException {
        if (this.getAge() < 18 || this.getAge() > 60) {
            throw new SoldierNotFoundException("Invalid age for soldier: " + this.getAge());
        }
        if (this.getRank() == null || this.getRank().trim().isEmpty()) {
            throw new SoldierNotFoundException("Rank cannot be null or empty");
        }
        if (this.specialty == null || this.specialty.trim().isEmpty()) {
            throw new SoldierNotFoundException("Specialty cannot be null or empty");
        }

        LOGGER.info("The rest of the code");
    }
    public void createSpecialForces() {
        try {
            validateSoldier();
            LOGGER.info("SpecialForces created successfully.");
        } catch (SoldierNotFoundException e) {
            LOGGER.error("Error creating SpecialForces: " + e.getMessage());
        }
    }
    @Override
    public String toString() {
        return "SpecialForces" +
                "name='" + getName() +
                ", age=" + getAge() +
                ", rank='" + getRank() +
                ", specialty='" + specialty;
    }

}


