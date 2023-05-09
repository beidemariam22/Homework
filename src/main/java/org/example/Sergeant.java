package org.example;

import java.util.List;

public final class Sergeant extends Soldier {
    private int activeseregant;
    private int inactiveseregant;

    public Sergeant() {
        this.activeseregant=0;
        this.inactiveseregant=0;
    }
    public Sergeant(String name, int age, String rank,String department,int numsoldiers, List<Aircraft> aircraft, List<Tank> tanks, List<Artillery> artillery, int activeseregant, int inactiveseregant) {
        super(name, age, rank,department,numsoldiers,aircraft,tanks,artillery);
        this.activeseregant=activeseregant;
        this.inactiveseregant=inactiveseregant;
    }
    public void setNumberOfActiveSeregant(int numberOfActiveSeregant){
        this.activeseregant= activeseregant;
    }
    public void setNumberOfInctiveSeregant(int numberOfInactiveSeregant){
        this.inactiveseregant =inactiveseregant;
    }
    public int getNumberOfActiveSeregant(){
        return activeseregant;
    }
    public int getNumberOfInactiveSeregant(){
        return inactiveseregant;
    }

    @Override
    public  void speak(){
        System.out.println("I am an officer. My name is " + name + " and I am " + age + " years old."+rank+"General");
    }
    public final void motivate() {
        System.out.println("Sergeant motivates the troops.");
    }

}
