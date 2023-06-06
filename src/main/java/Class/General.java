package Class;
import Interface.Ipromote;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class General extends Officer  implements Ipromote{

    private static final Logger LOGGER= LogManager.getLogger(General.class);
    public General() {

    }
    public General(String name, int age, String rank,String department, String location,
                   int yearsofservice, String branch) {
        super(name, age, rank,department,location,yearsofservice,branch);
    }

    @Override
    public  void speak(){
        LOGGER.info("My name is " + getName() + ", " +
                "I am " + getAge() + " years old" + " I have a "+
                getRank() + " rank in " + getDepartment()+ " department." );
    }
    @Override
    public void status() {
        super.status();
        if (getYearsOfService() >= 30) {
            LOGGER.info("This General is eligible for retirement.");
        } else {
            int yearsUntilRetirement = 30 - getYearsOfService();
            LOGGER.info("This General has " + yearsUntilRetirement + " years until retirement.");
        }
    }
    @Override
    public void promote() {
         List<Soldier> soldiers=new ArrayList<>();
         LOGGER.info("General " + getName() + " makes promotions for the following soldiers:");
         for (Soldier s : soldiers) {
             LOGGER.info("- " + getAge());
         }
     }
    //overloading
    public void makeStrategy() {
        LOGGER.info("General makes a strategy!");
    }
    public void makeStrategy(String Name){
        LOGGER.info("General makes a strategy!");
    }

}
