package org.example;

import java.util.List;

import static org.example.Aircraft.LOGGER;

public final class PresidentGuard extends SpecialForces{
    private int presidentguard;
    private int visepresidentguard;
    public PresidentGuard() {
        this.presidentguard = 0;
        this.visepresidentguard = 0;
    }
    public PresidentGuard(String name, int age, String rank,String department,
                          String location, String specialty, int presidentguard, int visepresidentguard){
        super(name, age, rank,department,location,specialty);
        this.presidentguard=presidentguard;
        this.visepresidentguard=visepresidentguard;
    }
    public void setNumberOfGuards(int presidentguarduard){
        this.presidentguard=presidentguard;
    }
    public void setNumberOfVisePresidentGuard(int visepresidentguard){
        this.visepresidentguard=visepresidentguard;
    }
    public int getNumberOfGuards(){
        return presidentguard;
    }
    public int getNumberOfVisePresidentGuard(){
        return visepresidentguard;
    }
    @Override
    public  void speak(){
        LOGGER.info("I am an officer. My name is " + getName() + " and I am " + getAge() + " years old."+getRank()+"General"+ specialty +"army");
    }
    @Override
    public void specialMission(){
        System.out.print("Stand by when the president is under attack");
    }
    @Override
    public void status() {
        if (presidentguard > 0 || visepresidentguard > 0) {
            LOGGER.info("The President's Guard is on duty with the following numbers:");
            if (presidentguard > 0) {
                LOGGER.info("- " + presidentguard + " guards for the President");
            }
            if (visepresidentguard > 0) {
                LOGGER.info("- " + visepresidentguard + " guards for the Vice President");
            }
        } else {
            LOGGER.info("The President's Guard is not on duty at this time.");
        }
    }

}

