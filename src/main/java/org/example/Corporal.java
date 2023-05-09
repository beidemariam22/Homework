package org.example;

import java.util.List;

public final class Corporal extends Soldier{

    public Corporal() {

    }
    public Corporal(String name, int age, String rank,String department,int numsoldiers, List<Aircraft> aircraft, List<Tank> tanks, List<Artillery> artillery) {
        super(name, age, rank,department,numsoldiers,aircraft,tanks,artillery);
    }

    public void setSquad() {
        System.out.println("Corporal sets the squad.");
    }
    @Override
    public  void speak(){
        System.out.println("I am an officer. My name is " + name + " and I am " + age + " years old." + rank +"General");
    }
    @Override
    public void color(){
        System.out.println(outfit);
        System.out.println(shoes);

    }
}
