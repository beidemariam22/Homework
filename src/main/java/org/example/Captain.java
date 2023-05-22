package org.example;

import Interface.Isalute;

import java.util.List;

public final class Captain extends Officer  {
    public Captain() {
    }
    public Captain(String name, int age, String rank,String department,
                   String location, int yearsofservice, String branch) {
        super(name, age, rank,department, location,yearsofservice,branch);
    }

    public void planMission() {

        System.out.println("Captain plans the mission.");
    }

    @Override
    public void color() {
        System.out.println(outfit);
        System.out.println(shoes);
    }

}
