package collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListPractice {

    private final ArrayList<String> trailRunningDistances = new ArrayList<>();

    public ArrayList<String> addDistance(List<String> distances) {
        for (String distance : distances) {
            trailRunningDistances.add(distance);
        }

        return trailRunningDistances;
    }

    public ArrayList<String> removeDistance(String distance) {
        if(trailRunningDistances.remove(distance)) {
            return trailRunningDistances;
        }

        return null;
    }

    public String getDistance(int distanceIndex) {
        if (trailRunningDistances.size() > distanceIndex && distanceIndex >= 0) {
            return trailRunningDistances.get(distanceIndex);
        } else {
            return null;
        }
    }
}
