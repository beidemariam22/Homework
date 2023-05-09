package org.example;

import Enums.ArtilleryType;
import Interface.Iattack;
import Interface.Icolorable;
import Interface.Ioperate;

import java.util.List;

public final class Artillery extends MilitaryEquipments implements Ioperate, Icolorable, Iattack {

    public Artillery() {

    }

    public Artillery(String nameOfEquipment, String condition,int numsoldiers, List<Aircraft> aircraft, List<Tank> tanks, List<Artillery> artillery){
        super(nameOfEquipment,condition,numsoldiers,aircraft,tanks,artillery);
    }
    @Override
    public void color(){
        System.out.println(artillerys);
    }

    @Override
    public void operators() {
        System.out.println(artilleryoperator);
    }
    @Override
    public void attack() {
        for(ArtilleryType artilleryType:ArtilleryType.values())
        switch (artilleryType) {
            case HOWITZER:
                System.out.println("Firing howitzer with range of " + artilleryType.range + " meters");
                break;
            case MORTAR:
                System.out.println("Launching mortar with range of " + artilleryType.range + " meters");
                break;
            case ROCKET:
                System.out.println("Firing rocket with range of " + artilleryType.range + " meters");
                break;
            default:
                System.out.println("Invalid artillery type");
                break;
        }
    }
}

