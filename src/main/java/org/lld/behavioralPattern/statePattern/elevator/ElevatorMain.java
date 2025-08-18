package org.lld.behavioralPattern.statePattern.elevator;

public class ElevatorMain {
    public static void main(String[] args) {
        Helper02 helper = new Helper02();
        Solution solution = new Solution();

        // Initialize system with 10 floors and 2 lifts
        solution.init(10, 2, helper);

        helper.println("Initial Lift States:");
        printLiftStates(solution);

        // Request 1: From floor 0 to 5
        int assignedLift1 = solution.requestLift(0, 5);
        helper.println("Lift assigned for request (0 -> 5): " + assignedLift1);

        // Request 2: From floor 7 to 2
        int assignedLift2 = solution.requestLift(7, 2);
        helper.println("Lift assigned for request (7 -> 2): " + assignedLift2);

        // Simulate 10 seconds of ticks
        for (int t = 1; t <= 10; t++) {
            solution.tick();
            helper.println("After tick " + t + ":");
            printLiftStates(solution);
        }

        // Show people count on each lift
        for (int i = 0; i < 2; i++) {
            helper.println("Lift " + i + " has people: " + solution.getNumberOfPeopleOnLift(i));
        }
    }

    private static void printLiftStates(Solution solution) {
        String[] states = solution.getLiftStates();
        for (int i = 0; i < states.length; i++) {
            System.out.println("Lift " + i + " -> " + states[i]);
        }
    }
}
