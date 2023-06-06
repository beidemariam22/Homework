package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public final class Captain extends Officer  {
    private static final Logger LOGGER= LogManager.getLogger(Captain.class);
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

        LOGGER.info("Captain plans the mission.");
    }

    public void addCaptain(Captain  captain){
      captains.add(captain);
    }
    public  List<Captain> printCaptain(Supplier<Captain> captain){
         captain.get();
        return captains;
    }

    @Override
    public void color() {
        LOGGER.info(outfit);
        LOGGER.info(shoes);
    }
    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getYearsOfService());
    }
    @Override
    public boolean equals(Object obj) {
        Captain that = (Captain) obj; //down casting
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
        return "Captain{" +
                " Name='" + getName() +
                ", Age=" + getAge() +
                ", Rank='" + getRank() +
                ", YearsOfService" + getYearsOfService() +
                " ,Branch " + getBranch() + "}";
    }
}
