package org.example;

import Exceptions.WeaponMalfunctionException;

import java.util.List;

public abstract class MilitaryEquipments extends Army{
    private String nameOfEquipment;
    private String condition;
    //private Soldier assignTo;

    public MilitaryEquipments(){
        this.nameOfEquipment=null;
        this.condition=null;
    }
    public MilitaryEquipments(String nameOfEquipment, String condition, int numSoldiers, List<Aircraft> aircraft, List<Tank> tanks, List<Artillery> artillery){
        super(numSoldiers,aircraft,tanks,artillery);
        this.nameOfEquipment=nameOfEquipment;
        this.condition=condition;
       // this.assignTo=assignTo;
    }


    public String getNameOfEquipment() {
        return nameOfEquipment;
    }

    public void setNameOfEquipment(String nameOfEquipment) {
        this.nameOfEquipment = nameOfEquipment;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    public void weaponcheck() throws WeaponMalfunctionException {
        if (this.condition.equals("Bad")){
            throw new WeaponMalfunctionException("The weapon is not ready for mission because it's condition is "+this.condition);
        }
    }
    public void creatweapon(){
        try{
            weaponcheck();
            System.out.println("The weapon is ready for mission");
        }catch(WeaponMalfunctionException e){
            System.out.println("Error to prepare weapon for mission");
        }

    }
}