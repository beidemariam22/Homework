package Enums;

public enum JetType {
    FIGHTER (500),
    BOMBER(600),
    TRANSPORT(700);

 public final  int hight;
    JetType(int hight){
        this.hight=hight;
    }
}
