package collections;

import java.util.LinkedList;

public class LinkedListPractice {

    private final LinkedList<String> runners = new LinkedList<>();

    public LinkedList<String> addRunners(LinkedList<String> trailRunners) {
        if(runners.addAll(trailRunners)) {
            return runners;
        }

        return null;
    }

    public LinkedList<String> removeRunner(String runner) {
        if(runners.remove(runner)) {
            return runners;
        }

        return null;
    }

    public String getRunner(String runner) {
        for(int i = 0; i < runners.size(); i++) {
            if(runners.get(i).equals(runner)) {
                return runners.get(i);
            }
        }

        return null;
    }
}
