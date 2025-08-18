package org.lld.behavioralPattern.statePattern.elevator;

public class LiftRequest {
    private int startFloor, destinationFloor;
    LiftRequest(int start, int destination){
        this.startFloor=start;
        this.destinationFloor=destination;
    }
    public int getStartFloor() {
        return startFloor;
    }
    public int getDestinationFloor() {
        return destinationFloor;
    }
    public char getMoveDirection(){
        if(startFloor!=destinationFloor)
            return startFloor<destinationFloor ? 'U':'D';
        return 'I';
    }

    public String toString(){
        return "("+startFloor+", "+destinationFloor+")";
    }
}
