package org.example;
import Enums.EquipmentCondition;
import Enums.JetType;
import Enums.Salary;
import Enums.TankType;
import Exceptions.InvalidRankException;
import Exceptions.SoldierNotFoundException;
import Exceptions.WeaponMalfunctionException;
import Thread.MyRunnable;
import Thread.MyThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws SoldierNotFoundException, WeaponMalfunctionException, InvalidRankException, IOException, InterruptedException {

        PresidentGuard guard= new PresidentGuard("Beide",28," ","groundforce","West","Major",4000,3000);
        //guard.validateSoldier();// guard.salute();
        //guard.createSpecialForces();
        //guard.validaterank();
        //guard.checkrank();
        guard.status();

        Aircraft aircraft = new Aircraft<>(JetType.FIGHTER, 123456, "F-16", "Good", "Airbase");
        //aircraft.creatweapon();
        //aircraft.weaponcheck();
        System.out.println("newwwwwwww");
        aircraft.ThisLinkedList(new Aircraft(JetType.FIGHTER, 123456, "F-16", "GOOD", "Airbase"));
        aircraft.ThisLinkedList(new Aircraft(JetType.BOMBER, 153456, "F-16", "MAINTENANCE_NEEDED", "Airbase"));
        aircraft.ThisLinkedList(new Aircraft(JetType.TRANSPORT, 213456, "F-16","REFUELING_NEEDED", "Airbase"));
        System.out.println(aircraft.getAircraft());

        //aircraft.myMethod();
        //aircraft.attack();
        // aircraft.status();
        // Perform operations on the aircraft
        aircraft.operate();
        aircraft.attack();
        aircraft.defend();
        aircraft.useSpecialAbility();
        aircraft.retreat();
        aircraft.operators();
        aircraft.navigate();
        aircraft.communicate();
        aircraft.performMaintenance();
        aircraft.status();

       Artillery artillery = new  Artillery( 202020,"2020_ART","Good", "East");
       artillery.AddArtillery(new Artillery( 202020,"2020_ART","Good", "East"));
       artillery.AddArtillery(new Artillery( 202021,"2021_ART","Good", "East"));
       artillery.AddArtillery(new Artillery( 202022,"2021_ART","Good", "East"));
       System.out.println(artillery.getArtillery());

        //Adding Tank
       Tank tanks =  new  Tank(2020,"2021_ART", "Good", "East");
       tanks.AddTank(new Tank( 202020,"2021_ART","Good", "East"));
       tanks.AddTank(new Tank( 202021,"2021_ART","Good", "East"));
       tanks.AddTank(new Tank( 202022,"2021_ART","Good","East"));
       System.out.println(tanks.getTanks());

        //Hashing Tank
       // Tank tankss =  new  Tank(202020,"2021_ART", "Good", "East");
       tanks.HashingTank(TankType. LIGHT,new Tank(202020,"2021_ART","Good", "East"));
       tanks.HashingTank(TankType.MEDIUM,new Tank( 202021,"2021_ART","Good", "East"));
       tanks.HashingTank(TankType. HEAVY,new Tank( 202022,"2021_ART","Good","East"));
        //System.out.println("Iterating Hashmap..."+tanks);

       Sergeant  sergeantt= new Sergeant("Beide", 28,"General","GroundForce","West",1000,800);
       sergeantt.addSoldier(new Sergeant("Beide", 28,"General","GroundForce","West",100,200) );
       sergeantt.addSoldier(new Sergeant("Beide", 28,"General","GroundForce","West",100,200) );
       sergeantt.addSoldier(new Sergeant("Beide", 28,"General","GroundForce","West",100,200) );

       //For anonymous class
       System.out.println(sergeantt.filterSoldier(new Predicate<Sergeant>() {
            @Override
            public boolean test(Sergeant sergeant){
                if(sergeant.getAge()>18 && sergeant.getAge()<65){
                    return true;
                }return false;
            }
        }));
        //For Lambda Expression
        System.out.println(sergeantt.filterSoldier((Sergeant sergeant)->{
            if(sergeant.getAge()>18 && sergeant.getAge()<65){
                return true;
            }return false;
        }));

       Captain  capt = new Captain("Beide", 28,"General","GroundForce","West",10,"airforce");
       capt.addCaptain(new Captain("Beide", 28,"General","GroundForce","West",10,"airforce"));
       capt.addCaptain(new Captain("Beide", 28,"General","GroundForce","West",10,"airforce"));
       capt.addCaptain(new Captain("Beide", 28,"General","GroundForce","West",10,"airforce"));
       capt.addCaptain(new Captain("Beide", 28,"General","GroundForce","West",10,"airforce"));
       System.out.println(capt.printCaptain(()-> capt));

       LieutenantColonel colonel= new  LieutenantColonel("Beide", 28,"General","GroundForce","West",20,"Branch");
       colonel.addLieutenant(new  LieutenantColonel("Beide", 28,"General","GroundForce","West",20,"Branch"));
       colonel.addLieutenant(new  LieutenantColonel("Beide", 28,"General","GroundForce","West",20,"Branch"));
       colonel.addLieutenant(new  LieutenantColonel("Beide", 28,"General","GroundForce","West",20,"Branch"));
       colonel.addLieutenant(new  LieutenantColonel("Beide", 28,"General","GroundForce","West",20,"Branch"));
       colonel.processLieutenantColonel((consumer) -> System.out.println(colonel));
        List<Double> bonusSalaries = colonel.SalaryBonus(lieutenant -> {
            // Compute bonus salary for each LieutenantColonel object
            int yearsOfService = lieutenant.getYearsOfService();
            double baseSalary = Salary.LIEUTENANT_COLONEL.amount;
            double bonus = yearsOfService * 1000; // Example calculation: $1000 bonus per year of service
            return baseSalary + bonus;
        });
        System.out.println("Bonus Salaries: " + bonusSalaries);

       Major major= new  Major(  "Beide", 28,"General","GroundForce","West",20,"Branch");
       major.addMajor(new  Major("Beide", 28,"General","GroundForce","West",20,"Branch"));
       major.addMajor(new  Major("Beide", 28,"General","GroundForce","West",20,"Branch"));
       major.addMajor(new  Major("Beide", 28,"General","GroundForce","West",20,"Branch"));
       major.addMajor(new  Major("Beide", 28,"General","GroundForce","West",20,"Branch"));

       List<Major> filteredMajor = major.filterMajor(majorFilter -> majorFilter.getAge() > 18 && majorFilter.getAge() < 65);
       System.out.println(filteredMajor);

       Corporal corporal= new Corporal("Beide",28,   "Corporal",   "groundforce","West");
       corporal.listCorporal(new Corporal("Beide",28,"Corporal","groundforce","West"));
       corporal.listCorporal(new Corporal("Beide",28,"Corporal","groundforce","West"));
       corporal.listCorporal(new Corporal("Beide",28,"Corporal","groundforce","West"));
       System.out.println(corporal.filteredCorporal((Corporal corp)->{
            if(corp.getAge()>18 && corp.getAge()<65){
                return true;
            }return false;}));

        MyThread thread1 = new MyThread();
        thread1.start();

        MyRunnable thread2 = new MyRunnable();
        Thread thread3 = new Thread(thread2);
        thread1.join();
        thread3.start();
        ReadText read = new ReadText();
        read.ReadFile();

    }

}
