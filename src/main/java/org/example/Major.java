package org.example;

import Interface.Isalute;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public final class Major extends Officer {

    private List<Officer> officers = new ArrayList<>();

    public Major() {

    }

    public Major(String name, int age, String rank, String department, String location, int yearsofservice, String branch) {
        super(name, age, rank, department, location, yearsofservice, branch);
    }

    public List<Officer> getOfficers() {
        return officers;
    }

    public void setOfficers(List<Officer> officers) {
        this.officers = officers;
    }

    public final void coordinate() {

        System.out.println("Major coordinates the operations.");
    }

    public void status() {
        if (getYearsOfService() >= 10) {
            System.out.println("Major " + getName() + " has served for over 10 years and is eligible for retirement.");
        } else {
            int yearsLeft = 10 - getYearsOfService();
            System.out.println("Major " + getName() + " has " + yearsLeft + " years left until retirement eligibility.");
        }
    }

    public void addSoldier(Officer officer) {
        officers.add(officer);
    }

    public List<Officer> filterMajor(Function<Officer, Boolean> officerFilter) {
        List<Officer> filteredOfficer = new ArrayList<>();
        for (Officer officer : officers) {
            if (officerFilter.apply(officer)) {
                filteredOfficer.add(officer);
            }
        }
        return filteredOfficer;
    }

    @Override
    public String toString() {
        return "Officer{" +
                " Name='" + getName() +
                ", Age=" + getAge() +
                ", Rank='" + getRank() +
                ", YearsOfService" + getYearsOfService() +
                " ,Branch " + getBranch() + "}";
    }
}

