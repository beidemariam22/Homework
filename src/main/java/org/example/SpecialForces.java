package org.example;

import Exceptions.SoldierNotFoundException;
import Interface.Isalute;

import java.util.List;

public abstract class SpecialForces extends Soldier implements Isalute {
    protected String specialty;
    public SpecialForces() {
        this.specialty = null;
    }
    public SpecialForces(String name, int age, String rank,String department, int numsoldiers, List<Aircraft> aircraft, List<Tank> tanks, List<Artillery> artillery, String specialty) {
        super(name, age, rank, department,numsoldiers, aircraft, tanks, artillery);
        this.specialty = specialty;
    }

    public abstract void specialMission();

    @Override
    public String toString() {
        return "SpecialForces" +
                "name='" + name +
                ", age=" + age +
                ", rank='" + rank +
                ", specialty='" + specialty;
    }

    @Override
    public int hashCode() {
        return this.age;
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
        return this.age == that.age &&
                this.name.equals(that.name) &&
                this.rank.equals(that.rank) &&
                this.specialty.equals(that.specialty);
    }

    public void validateSoldier() throws SoldierNotFoundException {
        if (this.age < 18 || this.age > 60) {
            throw new SoldierNotFoundException("Invalid age for soldier: " + this.age);
        }
        if (this.rank == null || this.rank.trim().isEmpty()) {
            throw new SoldierNotFoundException("Rank cannot be null or empty");
        }
        if (this.specialty == null || this.specialty.trim().isEmpty()) {
            throw new SoldierNotFoundException("Specialty cannot be null or empty");
        }

        System.out.println("The rest of the code");
    }
    public void createSpecialForces() {
        try {
            validateSoldier();
            System.out.println("SpecialForces created successfully.");
        } catch (SoldierNotFoundException e) {
            System.out.println("Error creating SpecialForces: " + e.getMessage());
        }
    }
}


