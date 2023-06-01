package StreamAndReflection;

import org.example.Corporal;

import java.util.ArrayList;
import java.util.List;

public class Stream {

    public static void main(String[] args){

        List<Corporal> list = new ArrayList<>();
        list.add(new Corporal("Beide",29,"Corporal","groundforce","West"));
        list.add(new Corporal("James",84,"Corporal","groundforce","West"));
        list.add(new Corporal("Robert",30,"Corporal","groundforce","West"));
        list.add(new Corporal("Nicolsen",76,"Corporal","groundforce","West"));
        list.add(new Corporal("Nigus",58,"Corporal","groundforce","West"));

        // Collection Streaming

        // 1. Stream all soldiers' names
        System.out.println("The list of all corporals");
        list.stream()
                .map(Corporal::getName)
                .forEach(System.out::println);
        System.out.println("---");

        // 2. Filter soldiers above the age of 30
        System.out.println("The list of corporals whose age are above 30");
        list.stream()
                .filter(cor->cor.getAge()>30)
                .map(Corporal::getName)
                .forEach(System.out::println);
        // 3. Count the total number of soldiers
        long totalCorporals=list.stream()
                .map(Corporal::getName)
                .count();
        System.out.println("The total number of corporals in the army "+totalCorporals);
        System.out.println("---");

        //4. Computing average of corporal's age
        double averageAge=list.stream()
                .mapToInt(Corporal::getAge)
                .average()
                .getAsDouble();
        System.out.println("The average of the Corporal's Age is "+ averageAge);
        System.out.println("---");

        // 5. Find the oldest soldier's name
        String oldestCorporalName =  list.stream()
                .max((corporal1,corporal2)->corporal1.getAge()-corporal2.getAge())
                .map(Corporal::getName)
                .orElse("No Corporal Found");
        System.out.println("The name of the oldest corporal: " + oldestCorporalName);
        System.out.println("---");

        // 6. Get the list of soldiers sorted by age
//        List<Corporal> corporalsAscedning =list.stream()
//                .map(Corporal::getName)
//                .sorted((cor1,cor2)->cor1.getAge()-cor2.getAge())
//                .toList();

       // System.out.println("The name of the oldest corporal: " + corporalsAscedning);

        // 7. Check if any soldier is 30 years old
        boolean isThirtyYearOld =  list.stream()
                .anyMatch(p->p.getAge()==30);
        System.out.println("Is there any soldier who is 30 years old? " + isThirtyYearOld);
        System.out.println("---");

    }



}
