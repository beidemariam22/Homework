package org.example;

import Exceptions.WeaponMalfunctionException;

import java.util.List;

import static org.example.Aircraft.LOGGER;

public abstract class MilitaryEquipments extends Army{
    private String condition;
    private int serialnum;
    private String model;
    //private Soldier assignTo;

    public MilitaryEquipments(){
        this.condition=null;
    }
    public MilitaryEquipments(int serialnum,String model,String condition, String location){
        super(location);
        this.condition=condition;
        this.model=model;
        this.serialnum=serialnum;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {

        this.condition = condition;
    }
    public int getSerialNum() {
        return serialnum;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialnum = serialnum;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void weaponcheck() throws WeaponMalfunctionException {
        if (this.condition.equals("Bad")){
            throw new WeaponMalfunctionException("The weapon is not ready for mission because it's condition is "+ this.condition);
        }
    }
    public void creatweapon(){
        try{
            weaponcheck();
            LOGGER.info("The weapon is ready for mission");
        }catch(WeaponMalfunctionException e){
            LOGGER.error("Error to prepare weapon for mission");
        }

    }
}