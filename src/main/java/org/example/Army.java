package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Army  {
    public static String nameofarmy;
    private int numsoldiers;
    private List<Aircraft> aircraft;
    private List<Tank> tanks;
    private List<Artillery> artillery;

    static{
        nameofarmy="Ethiopian Army";
         }
    public Army() {
        this.numsoldiers = 0;
        this.aircraft = new ArrayList<>();
        this.tanks = new ArrayList<>();
        this.artillery = new ArrayList<>();
    }
    public Army(int numSoldiers, List<Aircraft> aircraft, List<Tank> tanks, List<Artillery> artillery) {
        this.numsoldiers = numSoldiers;
        this.aircraft = aircraft;
        this.tanks = tanks;
        this.artillery = artillery;
    }

    // getters and setters

    public int getNumSoldiers() {
        return numsoldiers;
    }

    public void setNumSoldiers(int numSoldiers) {
        this.numsoldiers = numSoldiers;
    }

    public List<Aircraft> getAircraft() {
        return aircraft;
    }

    public void setAircraft(List<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }

    public List<Tank> getTanks() {
        return tanks;
    }

    public void setTanks(List<Tank> tanks) {
        this.tanks = tanks;
    }

    public List<Artillery> getArtillery() {
        return artillery;
    }

    public void setArtillery(List<Artillery> artillery) {
        this.artillery = artillery;
    }

  //  public abstract void thisArmy();

}
