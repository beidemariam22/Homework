package org.example;

import java.util.List;

public final class PresidentGuard extends SpecialForces{
    private int presidentguard;
    private int visepresidentguard;
    public PresidentGuard() {
        this.presidentguard = 0;
        this.visepresidentguard = 0;
    }
    public PresidentGuard(String name, int age, String rank,String department,int numsoldiers, List<Aircraft> aircraft, List<Tank> tanks, List<Artillery> artillery, String specialty, int numberOfPresidentGuards, int numberOfVisePresidentGuard){
        super(name, age, rank,department,numsoldiers,aircraft,tanks,artillery,specialty);
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
        System.out.println("I am an officer. My name is " + name + " and I am " + age + " years old."+rank+"General"+ specialty +"army");
    }
    @Override
    public void specialMission(){
        System.out.print("Stand by when the president is under attack");
    }
}
