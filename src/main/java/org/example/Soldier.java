package org.example;

import Enums.Department;
import Enums.Rank;
import Exceptions.InvalidRankException;
import Interface.Icolorable;
import Interface.Isalute;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

public  abstract class Soldier extends Army implements Isalute, Icolorable {
    private String name;
    private int age;
    private String rank;
    private String department;

    public Soldier() {
        this.name = null;
        this.age = 0;
        this.rank = null;
        this.department = null;
    }

    public Soldier(String name, int age, String rank, String department, String location) {
        super(location);
        this.name = name;
        this.age = age;
        this.rank = rank;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public abstract void speak();

    public final void attack() {
        System.out.println("Soldier attacks!");
    }

    @Override
    public void status() {
        if (age < 18) {
            System.out.println("This soldier is too young to serve.");
        } else if (age < 25) {
            System.out.println("This soldier is a young recruit.");
        } else if (age < 40) {
            System.out.println("This soldier is a seasoned veteran.");
        } else {
            System.out.println("This soldier is approaching retirement.");
        }
    }

    @Override
    public void salute() {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.GENERAL) {
                System.out.println("Hand Salute with Palm Outward");
            } else {
                System.out.println("Hand Salute");
            }
        }
    }

    @Override
    public void color() {
        if (department.equals(Department.GROUNDFORCE)) {
            System.out.println("Wearing army uniform in color ");
        } else if (department.equals(Department.AIRFORCE)) {

            System.out.println("Wearing uniform in color ");
        } else {
            System.out.println("No uniform specified for department " + department);
        }
    }

    public void validaterank() throws InvalidRankException {
        if (rank.equals(null) || this.rank.trim().isEmpty()) {
            throw new InvalidRankException("The soldier has invalid rank ");
        }
    }

    public void checkrank() {
        try {
            validaterank();
            System.out.println("The soldier has valid rank");
        } catch (InvalidRankException e) {
            System.out.println("Error on the rank of the solider");
        }
    }

}
