package org.example;

import Interface.Isalute;

import java.util.List;

public final class WarrantOfficer extends Officer {
    private String specialty;
    public WarrantOfficer() {

        this.specialty = null;
    }
    public WarrantOfficer(String name, int age, String rank,String department, int numsoldiers, List<Aircraft> aircraft, List<Tank> tanks,
                          List<Artillery> artillery,  int yearsOfService, String specialty) {
        super(name, age, rank,department,numsoldiers,aircraft,tanks,artillery);
        this.specialty = specialty;
    }
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public final void provideExpertise() {
        System.out.println("Warrant Officer provides expertise in their specialty.");
    }

}
