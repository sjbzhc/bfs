package edu.york;

import java.util.*;

public class BFS {

    int pathCost;
    int initialState;
    int goalState;
    String[] actions = {"left", "right", "suck"};
    Map<Integer, Map<String, Integer>> transitionModel = new HashMap<>();

    public BFS(int initialState, int goalState) {
        this.pathCost = 0;
        this.initialState = initialState;
        this.goalState = goalState;
        initTransitionModel();
    }

    // Returns true if a solution was found, false otherwise
    public boolean evaluate() {
        int node = initialState;
        if (goalState == node) return true;
        List<Integer> frontier = new ArrayList<>();
        frontier.add(node);
        List<Integer> explored = new ArrayList<>();

        while (true) {
            if (frontier.isEmpty()) return false;
            node = frontier.remove(0);
            explored.add(node);
            System.out.println("For node: " + node);
            for (String action : actions) {
                int child = transitionModel.get(node).get(action);
                if (!(explored.contains(child) || frontier.contains(child))) {
                    if (goalState == child) {
                        System.out.println("added child: " + child);
                        return true;
                    }
                    frontier.add(child);
                    System.out.println("added child: " + child);
                }
            }
        }
    }

    private void initTransitionModel() {
        Map<String, Integer> transitions1 = new HashMap<>();
        Map<String, Integer> transitions2 = new HashMap<>();
        Map<String, Integer> transitions3 = new HashMap<>();
        Map<String, Integer> transitions4 = new HashMap<>();
        Map<String, Integer> transitions5 = new HashMap<>();
        Map<String, Integer> transitions6 = new HashMap<>();
        Map<String, Integer> transitions7 = new HashMap<>();
        Map<String, Integer> transitions8 = new HashMap<>();
        transitions1.put("left", 1);
        transitions1.put("right", 2);
        transitions1.put("suck", 3);
        transitions2.put("left", 1);
        transitions2.put("right", 2);
        transitions2.put("suck", 6);
        transitions3.put("left", 3);
        transitions3.put("right", 4);
        transitions3.put("suck", 3);
        transitions4.put("left", 3);
        transitions4.put("right", 4);
        transitions4.put("suck", 8);
        transitions5.put("left", 5);
        transitions5.put("right", 6);
        transitions5.put("suck", 7);
        transitions6.put("left", 5);
        transitions6.put("right", 6);
        transitions6.put("suck", 6);
        transitions7.put("left", 7);
        transitions7.put("right", 8);
        transitions7.put("suck", 7);
        transitions8.put("left", 7);
        transitions8.put("right", 8);
        transitions8.put("suck", 8);
        transitionModel.put(1, transitions1);
        transitionModel.put(2, transitions2);
        transitionModel.put(3, transitions3);
        transitionModel.put(4, transitions4);
        transitionModel.put(5, transitions5);
        transitionModel.put(6, transitions6);
        transitionModel.put(7, transitions7);
        transitionModel.put(8, transitions8);
    }
}
