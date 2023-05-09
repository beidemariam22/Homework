package org.example;

import Interface.Isalute;

import java.util.List;

public class General extends Officer  {
    private int yearsOfService;

    public General() {
        this.yearsOfService=0;
    }
    public General(String name, int age, String rank,String department, int numsoldiers, List<Aircraft> aircraft, List<Tank> tanks,
                             List<Artillery> artillery, int yearsOfService) {
        super(name, age, rank,department,numsoldiers,aircraft,tanks,artillery);
        this.yearsOfService = yearsOfService;
    }
    public int getYearsOfService() {
        return yearsOfService;
    }
    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }
    @Override
    public  void speak(){
        System.out.println("My name is " + name + ", " +
                "I am " + age + " years old" + " I have a "+
                rank + " rank in " + department+ " department." );
    }

    //overloading
    public void makeStrategy() {
        System.out.println("General makes a strategy!");
    }
    public void makeStrategy(String Name){
        System.out.println("General makes a strategy!");
    }

}
