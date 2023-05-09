package org.example;

import Enums.TankType;
import Interface.Iattack;
import Interface.Ioperate;

import java.util.List;

public class Tank extends MilitaryEquipments implements Ioperate, Iattack {

    public Tank() {

    }

    public Tank(String nameOfEquipment, String condition, int numSoldiers, List<Aircraft> aircraft, List<Tank> tanks, List<Artillery> artillery) {
        super(nameOfEquipment, condition, numSoldiers, aircraft, tanks, artillery);

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
}