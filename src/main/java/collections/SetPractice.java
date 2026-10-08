package collections;

import java.util.HashSet;
import java.util.Set;

public class SetPractice {

    private final Set<String> completedTrails = new HashSet<>();

    public Set<String> addTrails(Set<String> trails) {
        completedTrails.addAll(trails);

        return completedTrails;
    }

    public Set<String> removeTrail(String trail) {
        completedTrails.remove(trail);

        return completedTrails;
    }

    public String getTrail(String trail) {
        String notFoundMessage = "Ты его ещё не пробежал, слабак.";

        if (completedTrails.isEmpty()) {
            return notFoundMessage;
        }

        var iterator = completedTrails.iterator();
        do {
            var completedTrail = iterator.next();

            if (completedTrail.equals(trail)) {
                return completedTrail;
            }
        } while (iterator.hasNext());

        return notFoundMessage;
    }
}
