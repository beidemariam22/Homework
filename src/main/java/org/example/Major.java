package org.example;

import Interface.Isalute;

import java.util.List;

public final class  Major extends Officer  {

    public int yearofservice;
    public Major() {

    }
    public Major(int yearofservice, String name, int age, String rank,String department, int numsoldiers, List<Aircraft> aircraft, List<Tank> tanks,
                 List<Artillery> artillery) {
        super(name, age, rank,department,numsoldiers,aircraft,tanks,artillery);
        this.yearofservice=yearofservice;
    }
    public final void coordinate() {

        System.out.println("Major coordinates the operations.");
    }
    @Override
    public void color(){
        System.out.println(outfit);
        System.out.println(shoes);

    }

}
