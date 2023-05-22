package org.example;

import Enums.ArtilleryType;
import Enums.EquipmentCondition;
import Interface.Iattack;
import Interface.Icolorable;
import Interface.Ioperate;

import java.util.ArrayList;
import java.util.List;


public final class Artillery extends MilitaryEquipments implements Ioperate, Icolorable, Iattack {
    private List<Artillery> artillery = new ArrayList<>();

    public Artillery() {
     //  this.artillery=null;
    }

    public Artillery(int serialnum, String model, String condition, String location){
        super(serialnum,model,condition, location);
       // this.artillery=artillery;
    }

    public List<Artillery> getArtillery() {
      return artillery;
  }
//
//    public void setArtillery(List<Artillery> artillery) {
//
//        this.artillery = artillery;
//    }

    @Override
    public void color(){

        System.out.println(artillerys);
    }

    @Override
    public void operators() {

        System.out.println(artilleryoperator);
    }

    public void AddArtillery(Artillery artilleries){
        artillery.add(artilleries);
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

    @Override
    public void status() {
        System.out.println("Aircraft Status:");
        EquipmentCondition condition = getConditionEnum();
        System.out.println(condition.getMessage());
    }

    private EquipmentCondition getConditionEnum() {
        String condition = getCondition();
        switch (condition) {
            case "Good":
                return EquipmentCondition.GOOD;
            case "Not Good":
                return EquipmentCondition.NOT_GOOD;
            case "Maintenance Needed":
                return EquipmentCondition.MAINTENANCE_NEEDED;
            case "No Maintenance Needed":
                return EquipmentCondition.NO_MAINTENANCE_NEEDED;
            case "Refueling Needed":
                return EquipmentCondition.REFUELING_NEEDED;
            default:
                return EquipmentCondition.UNKNOWN;
        }
    }
    @Override
    public String toString() {
        return  "Artillery {"+"Serialnumber "+ getSerialNum()+
                ", Model "+ getModel() +
                ", Condition "+ getCondition()+
                ", Location "+ getLocation()+"}";

    }
}

