package org.example;

import java.util.List;

public  class Officer extends Soldier {

    public Officer() {
    }
    public Officer(String name, int age, String rank,String department, int numsoldiers, List<Aircraft> aircraft, List<Tank> tanks, List<Artillery> artillery) {
        super(name, age, rank,department,numsoldiers,aircraft,tanks,artillery);
    }
    @Override
    public  void speak(){
        System.out.println("I am an officer. My name is " + name + " and I am " + age + " years old."+rank+"General"+department+"army");
    }
    public final void giveOrders() {
        System.out.println("Officer gives orders!");
    }

}
