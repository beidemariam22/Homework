package org.example;

import java.util.List;

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
        System.out.println("I am an officer. My name is " + getName() + " and I am " + getAge() + " years old. " +
                "I have a " + getRank() + " rank in " + getDepartment() + " department. I am from the " + branch + " branch.");
    }

    public void giveOrders() {
        System.out.println("Officer gives orders!");
    }

    public void status() {
        if (yearsofservice > 20) {
            System.out.println("I am a veteran officer with over 20 years of service.");
        } else if (yearsofservice > 10) {
            System.out.println("I am an experienced officer with over 10 years of service.");
        } else {
            System.out.println("I am a relatively new officer with less than 10 years of service.");
        }
    }
}
