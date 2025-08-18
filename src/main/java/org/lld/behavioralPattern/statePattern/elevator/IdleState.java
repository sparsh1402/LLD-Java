package org.lld.behavioralPattern.statePattern.elevator;

public class IdleState extends LiftState{
    IdleState(Lift lift) {
        super(lift);
    }

    public char getDirection() {
        return 'I';
    }

    public int getTimeToReachFloor(int floor, char direction) {
        return Math.abs(floor-lift.getCurrentFloor());
    }
}
