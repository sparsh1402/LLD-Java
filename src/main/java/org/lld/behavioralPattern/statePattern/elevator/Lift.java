package org.lld.behavioralPattern.statePattern.elevator;

import java.util.ArrayList;
import java.util.List;

public class Lift {
    private int currentFloor;
    private ArrayList<LiftRequest> requests;
    private LiftState movingUpState,
            movingDownState, idleState, state;

    Lift(){
        requests = new ArrayList<LiftRequest>();
        movingUpState = new MovingUpState(this);
        movingDownState = new MovingDownState(this);
        idleState = new IdleState(this);
        state = idleState;
    }

    public boolean hasStopInOppositeDirection() {
        char direction = state.getDirection();
        if (direction == 'I') {
            return false;
        }
        for (LiftRequest request : requests) {
            if (request.getMoveDirection() != state.getDirection()) {
                return true;
            }
        }
        return false;
    }

    int getTimeToReachFloor(int floor, char direction){
        return state.getTimeToReachFloor(floor, direction);
    }

    boolean hasStop(int floor , char moveDirection){
        for(int i=0;i<requests.size();i++){
            LiftRequest request = requests.get(i);
            if(request.getStartFloor()==floor
                    || request.getDestinationFloor()==floor){
                if(moveDirection == request.getMoveDirection())
                    return true;
            }
        }
        return false;
    }

    /** count number of people who will be on given floor
     in given direction
     */
    public int countPeople(int floor, char direction){
        int people=0;
        for(LiftRequest request: requests)
            if(request.getMoveDirection()==direction){
                if(direction=='U' && floor>=request.getStartFloor()
                        && floor<request.getDestinationFloor()) people++;
                else if(direction=='D' && floor<=request.getStartFloor()
                        && floor>request.getDestinationFloor()) people++;
            }
        return people;
    }


    char getMoveDirection(){
        return state.getDirection();
    }
    int getCurrentFloor(){
        return currentFloor;
    }

    public boolean hasSpace(int startFloor, int destinationFloor) {
        if(startFloor==destinationFloor) return false;
        char direction = (startFloor < destinationFloor) ? 'U' : 'D';
        if(direction=='U'){
            for(int floor=startFloor;floor<destinationFloor;floor++)
                if (countPeople(floor, direction) >= 10) {
                    return false;
                }
        }
        else{
            for(int floor=startFloor;floor>destinationFloor;floor--)
                if (countPeople(floor, direction) >= 10) {
                    return false;
                }
        }
        return true;
    }

    void updateLiftState(){
        if(requests.size()==0||state.getDirection()=='I'){
            setState('I');
            return;
        }
        state.updateFloor();
        updateRequests();
        if (requests.size() == 0) state = idleState;
        else state.updateDirection();
    }

    // updates people moving out of lift
    public void updateRequests(){
        char direction = state.getDirection();
        if(direction=='I') return;
        ArrayList<LiftRequest> newRequests = new ArrayList<>();
        // removing old requests
        for(LiftRequest request: requests){
            if(direction==request.getMoveDirection()){
                boolean liftPassedDestinationGoingUp = direction=='U' &&
                        currentFloor>=request.getDestinationFloor();
                boolean liftPassedDestinationGoingDown = direction=='D' &&
                        currentFloor<=request.getDestinationFloor();
                if(liftPassedDestinationGoingUp
                        || liftPassedDestinationGoingDown)
                    continue;
            }
            newRequests.add(request);
        }
        requests= newRequests;
    }

    void addRequest(int start, int destination){
        requests.add(new LiftRequest(start, destination));
        if(requests.size()==1){
            char direction = requests.get(0).getMoveDirection();
            if(start>currentFloor) direction='U';
            if(start<currentFloor) direction='D';
            setState(direction);
        }
    }

    public void setState(char direction){
        if(direction=='U'){
            this.state=movingUpState;
            return;
        }
        if(direction=='D'){
            this.state=movingDownState;
            return;
        }
        this.state = idleState;
    }


    public List<LiftRequest> getRequests() {
        return requests;
    }

    public void setCurrentFloor(int currentFloor){
        this.currentFloor= currentFloor;
    }



}

