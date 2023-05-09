package org.example;

import Interface.Isalute;

import java.util.List;

public final class Captain extends Officer  {
    public Captain() {

    }

    public Captain(String name, int age, String rank,String department, int numsoldiers, List<Aircraft> aircraft, List<Tank> tanks,
                   List<Artillery> artillery, int yearsOfService) {
        super(name, age, rank,department, numsoldiers, aircraft, tanks, artillery);

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
