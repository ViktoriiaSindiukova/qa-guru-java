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

    static void main(String[] args) {
        runArrayListPractice();
        runMapPractice();
        runLinkedListPractice();
        runSetPractice();

    }

    static void runArrayListPractice() {
        List<String> trailRunningDistances = List.of(
                "Wild Peak",
                "Elbrus",
                "Arshyz"
        );

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
        Map<String, String> trailRunningDistances = Map.of(
                "Wild Peak", "50km",
                "Elbrus", "60km",
                "Arshyz", "70km"
        );

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
        List<String> runners = List.of(
                "Dmitry Mityaev",
                "Ekaterina Mityaeva",
                "Alexey Tolstenko",
                "Mikhail Dolgiy"
        );

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
        Set<String> completedTrails = Set.of(
                "Dagestan Wilde Trail",
                "Pumpkin cross"
        );

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
