package Class;

import java.util.ArrayList;
import java.util.List;

public abstract class Army  {
    public static String nameofarmy;
    private String location;

    static{
        nameofarmy="Ethiopian Army";
         }
    public Army() {
        this.location =null;

    }
    public Army(String location) {
        this.location = location;

    }

    // getters and setters

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public abstract void status();

}
