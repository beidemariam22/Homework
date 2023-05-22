package org.example;

import Enums.Rank;

import java.util.List;

public final class Corporal extends Soldier{

    public Corporal() {

    }
    public Corporal(String name, int age, String rank,String department,String location) {
        super(name, age, rank,department,location);
    }

    public void setSquad() {

        System.out.println("Corporal sets the squad.");
    }
    @Override
    public  void speak(){
        System.out.println("I am an officer. My name is " + getName() + " and I am " + getAge() + " years old." + getRank() +"General");
    }
    @Override
    public void status(){
            super.status();
            if (getRank().equals(Rank.PRIVATE)) {
                System.out.println("This Corporal is leading a group of Privates.");
            } else if (getRank().equals(Rank.SERGEANT)){
                System.out.println("This Corporal is serving as a squad leader.");
            } else{
                System.out.println("This Corporal is serving in a higher leadership position.");
            }
            if (getAge() >= 60) {
                System.out.println("This Corporal is eligible for retirement.");
            } else {
                int yearsuntilretirement = 60 - getAge();
                System.out.println("This Corporal has " + yearsuntilretirement + " years until retirement.");
            }
        }

    }

