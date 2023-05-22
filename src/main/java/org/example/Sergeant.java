package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public final class Sergeant extends Soldier {
    // Fields
    private int activeseregant;
    private int inactiveseregant;
    private List<Sergeant> sergeants = new ArrayList<>();

    // Constructors
    public Sergeant() {
        this.activeseregant = 0;
        this.inactiveseregant = 0;
    }

    public Sergeant(String name, int age, String rank, String department, String location,
                    int activeseregant, int inactiveseregant) {
        super(name, age, rank, department,location);
        this.activeseregant = activeseregant;
        this.inactiveseregant = inactiveseregant;
    }

    // Getter and Setter Methods
    public void setNumberOfActiveSeregant(int numberOfActiveSeregant) {
        this.activeseregant = numberOfActiveSeregant;
    }

    public void setNumberOfInctiveSeregant(int numberOfInactiveSeregant) {
        this.inactiveseregant = numberOfInactiveSeregant;
    }

    public int getNumberOfActiveSeregant() {
        return activeseregant;
    }

    public int getNumberOfInactiveSeregant() {
        return inactiveseregant;
    }

    public List<Sergeant> getSoldiers() {
        return sergeants;
    }

    public void setSoldiers(List<Sergeant> sergeants) {
        this.sergeants = sergeants;
    }

    // Methods
    @Override
    public void speak() {
        System.out.println("I am an officer. My name is "
                + getName() + " and I am " + getAge() + " years old. "
                + getRank() + " General");
    }
    public final void motivate() {
        System.out.println("Sergeant motivates the troops.");
    }
    public String getStatus() {
        if (activeseregant > 0) {
            return "We have " + activeseregant + " active sergeants.";
        } else if (inactiveseregant > 0) {
            return "We have " + inactiveseregant + " inactive sergeants.";
        } else {
            return "We have no sergeants.";
        }
    }

    public void addSoldier(Sergeant sergeant){
        sergeants.add(sergeant);
    }
    public List<Sergeant> filterSoldier(Predicate<Sergeant> sergeant) {
        List<Sergeant> soll = new ArrayList<>();
        for (Sergeant sol : sergeants)
            if (sergeant.test(sol)) {
                soll.add(sol);
            }
            return soll;
        }
    @Override
    public String toString() {
        return "Sergeant{" +
                " Name='" + getName() +
                ", Age=" + getAge() +
                ", Rank='" + getRank()+
                ", Activeseregant"+activeseregant+
                " ,Inactiveseregant"+inactiveseregant+"}";

    }
}

