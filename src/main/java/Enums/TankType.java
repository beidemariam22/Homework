package Enums;

public enum TankType {
    LIGHT(4000),
    MEDIUM(800),
    HEAVY(600);

    public final int attackpower;
    TankType(int attackpower){
        this.attackpower=attackpower;
    }
}
