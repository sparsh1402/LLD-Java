package org.lld.behavioralPattern.statePattern.elevator;

public class MovingDownState extends LiftState{
    MovingDownState(Lift lift) {
        super(lift);
    }

    public int getTimeToReachFloor(int floor, char direction) {
        int currentFloor = lift.getCurrentFloor();
        boolean hasStopOpposite = lift.hasStopInOppositeDirection();
        int minDownFloor = getMinDownFloor();
        // NOT ELIGIBLE: there are requests in opposite direction
        if (floor < minDownFloor && hasStopOpposite) return -1;
        if (direction == 'D') {
            if (floor == currentFloor) return 0;
            // NOT ELIGIBLE : lift has already passed floor
            if (floor > currentFloor) return -1;
            return currentFloor - floor ;
        }
        if (floor <= minDownFloor) return currentFloor - floor;
        return currentFloor - minDownFloor + floor - minDownFloor;
    }


    public void updateFloor() {
        int minDownFloor = getMinDownFloor();
        if(lift.getCurrentFloor()>minDownFloor) {
            lift.setCurrentFloor(lift.getCurrentFloor() - 1);
        }
    }

    public void updateDirection(){
        if(lift.getCurrentFloor()<=getMinDownFloor()) {
            lift.setState('U');
        }
    }

    public char getDirection() {
        return 'D';
    }

    private int getMinDownFloor(){
        int floor = 1000*1000;
        for(LiftRequest request: lift.getRequests()){
            if(floor>request.getStartFloor()) floor= request.getStartFloor();
            if(floor>request.getDestinationFloor()) floor = request.getDestinationFloor();
        }
        return floor;
    }
}
