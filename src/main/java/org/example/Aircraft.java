package org.example;

import Enums.JetType;
import Interface.Iattack;
import Interface.Ioperate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static Enums.JetType.*;

public final class Aircraft<T> extends MilitaryEquipments implements Ioperate, Iattack {
    private String manufacturer;
    private int cost;
    private int serialNumber;
    private String model;
    public T aircrafttype;
    public Aircraft(String manufacturer, int cost, int serialNumber, String model,T aircrafttype, String nameOfEquipment, String condition, int numSoldiers, List<Aircraft> aircraft, List<Tank> tanks, List<Artillery> artillery){
        super(nameOfEquipment,condition,numSoldiers,aircraft,tanks,artillery);
        this.manufacturer=manufacturer;
        this.cost=cost;
        this.serialNumber=serialNumber;
        this.model=model;
        this.aircrafttype=aircrafttype;
    }
    public Aircraft() {
        super(null, null, 0, null, null, null);
        this.manufacturer = "";
        this.cost = 0;
        this.serialNumber = 0;
        this.model = "";
        this.aircrafttype=null;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public  void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public <T> void LinkedList(){
        MyLinkedList<T> list=new MyLinkedList<T>();
        list.add((T) "Fighter");
        list.add((T) "Bomber");
        list.add((T) "Transport");
        list.add((T) "Refueling");
        list.add((T) "Trainer");
        list.iterate();
    }
    @Override
    public void attack() {
        if(command && enemy) {
            for(JetType type: JetType.values())
            switch(type) {
                case FIGHTER:
                    System.out.println( "Fighter aircraft attacking enemy from " + type.hight + " meters" );
                    break;
                case BOMBER:
                    System.out.println("Bomber aircraft attacking enemy from " + type.hight + " meters");
                    break;
                case TRANSPORT:
                    System.out.println("Transport wound soldier in  " + type.hight + " meters");
                    break;
                default:
                    System.out.println("Invalid aircraft type");
                    break;
            }
        } else {
            System.out.println("Cannot attack without both command and enemy present");
        }
    }
    @Override
    public void operators() {
        System.out.println(numpilot);
    }
    private static final Logger logger = LogManager.getLogger(Aircraft.class);
    public void myMethod() {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.error("This is an error message");
    }
}
