package org.example;

import Enums.EquipmentCondition;
import Enums.TankType;
import Interface.Iattack;
import Interface.Ioperate;

import java.util.*;

public class Tank extends MilitaryEquipments implements Ioperate, Iattack {

    private Queue<Tank> tanks=new LinkedList<>();
    private Map<TankType,Tank> mapping=new HashMap<>();
    public Tank() {
      this.tanks=null;
    }

    public Tank(int serialnum, String model,
                String condition, String location) {
        super(serialnum,model,condition, location);
      //this.tanks=tanks;
    }
    public Queue<Tank> getTanks() {
       return tanks;
    }
//
//    public void setTanks(List<Tank> tanks) {
//
//        this.tanks = tanks;
//    }
     public void AddTank(Tank tank){
        tanks.offer(tank);
     }
    public void HashingTank(TankType tanktype, Tank tank){
        mapping.put(tanktype,tank);
//        for(Map.Entry m : mapping.entrySet()){
//            System.out.println(m.getKey()+"    "+m.getValue());
      // }
    }
    @Override
    public void operators() {
        System.out.println(tankoperator);
    }

    @Override
    public void attack() {
        for (TankType type : TankType.values()) {
            switch (type) {
                case HEAVY:
                    System.out.println("The heavy tank can attack with a heavy-caliber gun by  " + type.attackpower+ " Power");
                    break;
                case MEDIUM:
                    System.out.println("The medium tank can attack with a high-velocity gun by  " + type.attackpower+ " Power");
                    break;
                case LIGHT:
                    System.out.println("The light tank can attack with a single cannon by  " + type.attackpower+ " Power");
                    break;
                default:
                    System.out.println("Invalid tank type!");
            }
            if (command && enemy) {
                System.out.println("Tank is attacking with power: " + type.attackpower + " Power");
            } else {
                System.out.println("Cannot attack without command or enemy.");
            }
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
        return  "Tank {"+"Serialnumber "+ getSerialNum()+
                ", Model "+ getModel() +
                ", Condition "+ getCondition()+
                ", Location "+ getLocation()+"}";
    }
}