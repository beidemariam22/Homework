package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import Enums.Department;
import Exceptions.InvalidRankException;
import Exceptions.SoldierNotFoundException;
import Exceptions.WeaponMalfunctionException;
import java.util.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SoldierNotFoundException, WeaponMalfunctionException, InvalidRankException, IOException {
        List<Aircraft> aircraftList = new ArrayList<>();
        List<Tank> tankList = new ArrayList<>();
        List<Artillery> artilleryList = new ArrayList<>();
        MyLinkedList<Object> list= new MyLinkedList<>();
        PresidentGuard guard= new PresidentGuard("Beide",2," ","groundforce",200,aircraftList, tankList, artilleryList,"Major",4000,3000);
       // guard.validateSoldier();
        guard.salute();
       // guard.createSpecialForces();
        //guard.validaterank();
        //guard.checkrank();
        Aircraft aircraft = new Aircraft<>("Ethiopian", 100000, 202020, "hypersonic",list, "jet", "Bad", 300000, aircraftList, tankList, artilleryList);
        //aircraft.creatweapon();
        //aircraft.weaponcheck();

        ReadText read = new ReadText();
        read.ReadFile();

        //Object Object=0;
        aircraft.LinkedList();
        aircraft.myMethod();
        aircraft.attack();
    }
}
