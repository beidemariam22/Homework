package Interface;

public interface Iattack {
    boolean command = true;
    boolean enemy = true;

    void attack();

    void defend();

    void useSpecialAbility();

    void retreat();

    boolean isCommander();

    boolean hasEnemy();
}
