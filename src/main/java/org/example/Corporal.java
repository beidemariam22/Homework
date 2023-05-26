package org.example;

import Enums.Rank;
import Lambda.Ifilter;

import java.util.ArrayList;
import java.util.List;

public final class Corporal extends Soldier {

    private List<Corporal> corporals = new ArrayList<>();

    public Corporal() {

    }

    public Corporal(String name, int age, String rank, String department, String location) {
        super(name, age, rank, department, location);
    }

    public List<Corporal> getCorporals() {
        return corporals;
    }

    public void setCorporals(List<Corporal> corporals) {
        this.corporals = corporals;
    }

    public void setSquad() {

        System.out.println("Corporal sets the squad.");
    }

    @Override
    public void speak() {
        System.out.println("I am an officer. My name is " + getName() + " and I am " + getAge() + " years old." + getRank() + "General");
    }

    @Override
    public void status() {
        super.status();
        if (getRank().equals(Rank.PRIVATE)) {
            System.out.println("This Corporal is leading a group of Privates.");
        } else if (getRank().equals(Rank.SERGEANT)) {
            System.out.println("This Corporal is serving as a squad leader.");
        } else {
            System.out.println("This Corporal is serving in a higher leadership position.");
        }
        if (getAge() >= 60) {
            System.out.println("This Corporal is eligible for retirement.");
        } else {
            int yearsuntilretirement = 60 - getAge();
            System.out.println("This Corporal has " + yearsuntilretirement + " years until retirement.");
        }
    }

    public void ListCorporal(Corporal corporal) {
        corporals.add(corporal);
    }

    public List<Corporal> filteredCorporal(Ifilter<Corporal> filteredcorporal) {
        List<Corporal> cor = new ArrayList<>();
        for (Corporal corr : corporals)
            if (filteredcorporal.filter(corr)) {
                cor.add(corr);
            }
        return cor;
    }

    @Override
    public String toString() {
        return "Corporals{" +
                "Name " + getName() +
                ", Age" + getAge() +
                ", Rank " + getRank() +
                ", Department " + getDepartment() +
                ", Location " + getLocation() +
                "}";
    }
}
