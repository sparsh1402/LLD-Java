package org.lld.behavioralPattern.statePattern.elevator;

import java.util.List;

public interface Q002SmartElevatorGroupInterface {
    void init(int floors, int lifts, Helper02 helper);
    int requestLift(int currentFloor, int destinationFloor);
    String[] getLiftStates();
    int getNumberOfPeopleOnLift(int liftId);
    List<Integer> getLiftsStoppingOnFloor(int floor, char moveDirection);
    void tick(); // This method is called every second
}