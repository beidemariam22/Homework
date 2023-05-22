package org.example;

import Enums.Rank;
import Interface.Isalute;

import java.util.List;

public class General extends Officer  {


    public General() {

    }
    public General(String name, int age, String rank,String department, String location,
                   int yearsofservice, String branch) {
        super(name, age, rank,department,location,yearsofservice,branch);
    }

    @Override
    public  void speak(){
        System.out.println("My name is " + getName() + ", " +
                "I am " + getAge() + " years old" + " I have a "+
                getRank() + " rank in " + getDepartment()+ " department." );
    }
    @Override
    public void status() {
        super.status();
        if (getYearsOfService() >= 30) {
            System.out.println("This General is eligible for retirement.");
        } else {
            int yearsUntilRetirement = 30 - getYearsOfService();
            System.out.println("This General has " + yearsUntilRetirement + " years until retirement.");
        }
    }
    public void makePromotions(List<Soldier> soldiers) {
        System.out.println("General " + getName() + " makes promotions for the following soldiers:");
        for (Soldier s : soldiers) {
            System.out.println("- " + getAge());
        }
    }
    //overloading
    public void makeStrategy() {

        System.out.println("General makes a strategy!");
    }
    public void makeStrategy(String Name){

        System.out.println("General makes a strategy!");
    }

}
