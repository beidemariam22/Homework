package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public final class Captain extends Officer  {



    private List<Captain> captains=new ArrayList<>();
    public Captain() {
    }
    public Captain(String name, int age, String rank,String department,
                   String location, int yearsofservice, String branch) {
        super(name, age, rank,department, location,yearsofservice,branch);
    }
    public List<Captain> getCaptains() {
        return captains;
    }

    public void setCaptains(List<Captain> captains) {
        this.captains = captains;
    }
    public void planMission() {

        System.out.println("Captain plans the mission.");
    }

    public void addCaptain(Captain  captain){
      captains.add(captain);
    }
    public List<Captain> printCaptain(Supplier<Captain> captain){
            captain.get();
        return captains;
    }

    @Override
    public void color() {
        System.out.println(outfit);
        System.out.println(shoes);
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
