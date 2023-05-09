package Enums;

public enum ArtilleryType {
    HOWITZER (800),
    MORTAR(1200),
    ROCKET(2000);

    public final int range;
    ArtilleryType(int range){
        this.range=range;
    }
}
