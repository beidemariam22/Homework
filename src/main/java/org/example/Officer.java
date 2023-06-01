package org.example;

import java.util.List;

import static org.example.Aircraft.LOGGER;

public class Officer extends Soldier {

    private int yearsofservice;
    private String branch;

    public Officer() {
    }

    public Officer(String name, int age, String rank, String department,
                   String location, int yearsofservice, String branch) {
        super(name, age, rank, department, location);
        this.yearsofservice = yearsofservice;
        this.branch = branch;
    }
    public int getYearsOfService() {
        return yearsofservice;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsofservice = yearsofservice;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public void speak() {
        LOGGER.info("I am an officer. My name is " + getName() + " and I am " + getAge() + " years old. " +
                "I have a " + getRank() + " rank in " + getDepartment() + " department. I am from the " + branch + " branch.");
    }

    public void giveOrders() {
        System.out.println("Officer gives orders!");
    }

    public void status() {
        if (yearsofservice > 20) {
            LOGGER.info("I am a veteran officer with over 20 years of service.");
        } else if (yearsofservice > 10) {
            LOGGER.info("I am an experienced officer with over 10 years of service.");
        } else {
            LOGGER.info("I am a relatively new officer with less than 10 years of service.");
        }
    }
    @Override
    public int hashCode() {
        return this.getAge();
    }
    @Override
    public boolean equals(Object obj) {
        Officer that = (Officer) obj; //down casting
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        return this.getAge() == that.getAge() &&
                this.getName().equals(that.getName()) &&
                this.getRank().equals(that.getRank()) &&
                this.getDepartment().equals(that.getDepartment())&&
                this.getLocation().equals(that.getLocation())&&
                this.getYearsOfService() == that.getYearsOfService() &&
                this.getBranch().equals(that.getBranch());
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
