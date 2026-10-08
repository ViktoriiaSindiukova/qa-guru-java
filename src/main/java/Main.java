import collections.ArrayListPractice;
import collections.LinkedListPractice;
import collections.MapPractice;
import collections.SetPractice;

import java.util.*;

public class Main {

    static ArrayListPractice arrayListPractice = new ArrayListPractice();
    static MapPractice mapPractice = new MapPractice();
    static LinkedListPractice linkedListPractice = new LinkedListPractice();
    static SetPractice setPractice = new SetPractice();

    public static void main(String[] args) {
        runArrayListPractice();
        runMapPractice();
        runLinkedListPractice();
        runSetPractice();

    }

    static void runArrayListPractice() {
        ArrayList<String> trailRunningDistances = new ArrayList<>();
        trailRunningDistances.add("Wild Peak");
        trailRunningDistances.add("Elbrus");
        trailRunningDistances.add("Arshyz");

        System.out.println(
                arrayListPractice.addDistance(trailRunningDistances)
        );
        System.out.println(
                arrayListPractice.removeDistance("Arshyz")
        );
        System.out.println(
                arrayListPractice.getDistance(1)
        );
    }

    static void runMapPractice() {
        Map<String, String> trailRunningDistances = new HashMap<>();
        trailRunningDistances.put("Wild Peak", "50km");
        trailRunningDistances.put("Elbrus", "60km");
        trailRunningDistances.put("Arshyz", "70km");

        System.out.println(
                mapPractice.addDistance(trailRunningDistances, "Grut", "80km")
        );
        System.out.println(
                mapPractice.removeDistance("Arshyz")
        );
        System.out.println(
                mapPractice.getDistance("Grut")
        );
    }

    static void runLinkedListPractice() {
        LinkedList<String> runners = new LinkedList<>();
        runners.add("Dmitry Mityaev");
        runners.add("Ekaterina Mityaeva");
        runners.add("Alexey Tolstenko");
        runners.add("Mikhail Dolgiy");

        System.out.println(
                linkedListPractice.addRunners(runners)
        );
        System.out.println(
                linkedListPractice.removeRunner("Alexey Tolstenko")
        );
        System.out.println(
                linkedListPractice.getRunner("Ekaterina Mityaeva")
        );
    }

    static void runSetPractice() {
        Set<String> completedTrails = new HashSet<>();
        completedTrails.add("Dagestan Wilde Trail");
        completedTrails.add("Pumpkin cross");

        System.out.println(
                setPractice.addTrails(completedTrails)
        );
        System.out.println(
                setPractice.removeTrail("Pumpkin cross")
        );
        System.out.println(
                setPractice.getTrail("Grut")
        );
    }
}
