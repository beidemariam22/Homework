package org.example;

import Interface.Isalute;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public final class Major extends Officer {
    private static final Logger LOGGER= LogManager.getLogger(Major.class);
    private List<Major> majors = new ArrayList<>();

    public Major() {

    }

    public Major(String name, int age, String rank, String department, String location, int yearsofservice, String branch) {
        super(name, age, rank, department, location, yearsofservice, branch);
    }

    public List<Major> getMajors() {
        return majors;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
    }

    public final void coordinate() {

        LOGGER.info("Major coordinates the operations.");
    }
    public void status() {
        if (getYearsOfService() >= 10) {
            LOGGER.info("Major " + getName() + " has served for over 10 years and is eligible for retirement.");
        } else {
            int yearsLeft = 10 - getYearsOfService();
            LOGGER.info("Major " + getName() + " has " + yearsLeft + " years left until retirement eligibility.");
        }
    }
    public void addMajor(Major major) {
        majors.add(major);
    }
    public List<Major> filterMajor(Function<Major, Boolean> majorFilter) {
        List<Major> filteredMajor = new ArrayList<>();
        for (Major major : majors) {
            if (majorFilter.apply(major)) {
                filteredMajor.add(major);
            }
        }
        return filteredMajor;
    }
    @Override
    public String toString() {
        return "Major{" +
                " Name='" + getName() +
                ", Age=" + getAge() +
                ", Rank='" + getRank() +
                ", YearsOfService" + getYearsOfService() +
                " ,Branch " + getBranch() + "}";
    }
}

