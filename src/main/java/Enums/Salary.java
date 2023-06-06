package Enums;

public enum Salary {
    PRIVATE(23067),
    CORPORAL(38250),
    SERGEANT(46881),
    LIEUTENANT(57978),
    CAPTAIN(87195),
    MAJOR(116181),
    LIEUTENANT_COLONEL(151805),
    COLONEL(185659),
    TANKOPERATOR(160000),
    ARTILLERYOPERATOR(150000),
    GENERAL(222680 );

    public double amount;
    Salary(double amount){
        this.amount=amount;
    }
}
