package org.example;

import Enums.Department;
import Enums.Rank;
import Exceptions.InvalidRankException;
import Interface.Icolorable;
import Interface.Isalute;

import java.util.List;

public  abstract class Soldier extends Army implements Isalute, Icolorable {
    protected String name;
    protected int age;
    protected String rank;
    protected String department;
    public Soldier() {
        this.name = null;
        this.age = 0;
        this.rank = null;
        this.department=null;
    }

    public Soldier(String name, int age, String rank, String department,int numsoldiers, List<Aircraft> aircraft, List<Tank> tanks, List<Artillery> artillery) {
        super(numsoldiers,aircraft,tanks,artillery);
        this.name = name;
        this.age = age;
        this.rank = rank;
        this.department=department;
    }
    public abstract void speak();
    public final void attack() {
        System.out.println("Soldier attacks!");
    }

    @Override
    public void salute() {
        for (Rank rank : Rank.values()){
            if (rank == Rank.GENERAL){
                System.out.println("Hand Salute with Palm Outward");
            }else {
                System.out.println("Hand Salute");
            }
        }
    }

    @Override
    public void color() {
        if (department.equals(Department.GROUNDFORCE)) {
                System.out.println("Wearing army uniform in color " );
            } else if (department.equals(Department.AIRFORCE)) {

                System.out.println("Wearing uniform in color " );
            } else {
            System.out.println("No uniform specified for department " + department);
        }
    }
    public void validaterank() throws InvalidRankException{
        if(rank.equals(null) || this.rank.trim().isEmpty()){
            throw new InvalidRankException("The soldier has invalid rank ");
        }
    }
    public void checkrank(){
        try{
            validaterank();
            System.out.println("The soldier has valid rank");
        }catch(InvalidRankException e){
            System.out.println("Error on the rank of the solider");
        }
    }
}
