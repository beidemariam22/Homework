package org.example;

import Interface.Isalute;

import java.util.List;

public final class LieutenantColonel extends Officer {

    public LieutenantColonel() {

    }
    public LieutenantColonel(String name, int age, String rank,String department, int numsoldiers, List<Aircraft> aircraft, List<Tank> tanks,
                             List<Artillery> artillery) {
        super(name, age, rank,department,numsoldiers,aircraft,tanks,artillery);
    }

    public final void oversee() {
        System.out.println("Lieutenant Colonel oversees the deployment.");
    }

    @Override
    public void color(){
        System.out.println(outfit);
        System.out.println(shoes);

    }

}
