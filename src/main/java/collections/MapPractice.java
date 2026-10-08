package collections;

import java.util.HashMap;
import java.util.Map;

public class MapPractice {

    private final Map<String, String> trailRunningDistances = new HashMap<>();

    public Map<String, String> addDistance(Map<String, String> distances, String trailName, String distance) {
        trailRunningDistances.putAll(distances);
        trailRunningDistances.put(trailName, distance);

        return trailRunningDistances;
    }

    public Map<String, String> removeDistance(String trailName) {
        trailRunningDistances.remove(trailName);

        return trailRunningDistances;
    }

    public String getDistance(String trailName) {
        var iterator = trailRunningDistances.entrySet().iterator();

        while (iterator.hasNext()) {
            var entry = iterator.next();

            if (entry.getKey().equals(trailName)) return entry.getValue();
        }

        return null;
    }
}
