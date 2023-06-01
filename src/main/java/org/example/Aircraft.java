package org.example;

import Enums.EquipmentCondition;
import Enums.JetType;
import Interface.Iattack;
import Interface.Ioperate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Aircraft<T> extends MilitaryEquipments implements Ioperate, Iattack {

    private List<Aircraft> aircrafts = new ArrayList<>();
    public T aircrafttype;
    static final Logger LOGGER = LogManager.getLogger(Aircraft.class);
    public Aircraft(T aircrafttype,int serialnum, String model,
                      String condition, String location) {
        super(serialnum,model,condition, location);
        this.aircrafttype = aircrafttype;
     //   this.aircrafts = aircrafts;
    }

    public Aircraft() {
        this.aircrafttype = null;
        //this.aircrafts=null;
    }


    public List<Aircraft> getAircraft() {
       return aircrafts;
   }
//
//    public void setAircraft(MyLinkedList<Aircraft> aircraft) {
//        this.aircrafts = aircrafts;
//    }

    public <T> void ThisLinkedList(Aircraft aircraft) {
        aircrafts.add(aircraft);
        //System.out.println(aircraft);
        //aircrafts.iterate();
    }
    @Override
    public void attack() {
        if (command && enemy) {
            for (JetType type : JetType.values())
                switch (type) {
                    case FIGHTER:
                        LOGGER.info("Fighter aircraft attacking enemy from " + type.hight + " meters");
                        break;
                    case BOMBER:
                        LOGGER.info("Bomber aircraft attacking enemy from " + type.hight + " meters");
                        break;
                    case TRANSPORT:
                        LOGGER.info("Transport wound soldier in  " + type.hight + " meters");
                        break;
                    default:
                        LOGGER.info("Invalid aircraft type");
                        break;
                }
        } else {
            LOGGER.info("Cannot attack without both command and enemy present");
        }
    }

    @Override
    public void operators() {
        LOGGER.info(numpilot);
    }
    public void myMethod() {
        LOGGER.debug("This is a debug message");
        LOGGER.info("This is an info message");
        LOGGER.error("This is an error message");
    }
    @Override
    public void status() {
        LOGGER.info("Aircraft Status:");
        EquipmentCondition condition = getConditionEnum();
        LOGGER.info(condition.getMessage());
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
        return
                "Aircraft {"+"Aircrafttype "+ aircrafttype +
                ", Serialnumber "+ getSerialNum()+
                ", Model "+ getModel() +
                ", Condition "+ getCondition()+
                ", Location "+ getLocation() +"}";
    }

}

