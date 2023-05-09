package Enums;

public enum Rank {
    PRIVATE("No rank insignia"),
    CORPORAL("2 chevrons"),
    SERGEANT("3 chevrons"),
    LIEUTENANT("1 gold bar"),
    CAPTAIN("2 gold bars"),
    MAJOR("Gold oak leaf"),
    LIEUTENANT_COLONEL("Silver oak leaf"),
    COLONEL("Silver eagle"),
    GENERAL("4 silver stars");

    final String mark;
    Rank(String mark){
        this.mark=mark;
    }
}
