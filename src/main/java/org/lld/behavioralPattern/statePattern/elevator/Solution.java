package org.lld.behavioralPattern.statePattern.elevator;

import java.util.ArrayList;
import java.util.List;

public class Solution implements Q002SmartElevatorGroupInterface {
    int floors, liftsCount;
    Helper02 helper ;
    private Lift lifts[];

    public Solution(){}

    public void init(int floors, int lifts, Helper02 helper) {
        this.floors = floors;
        this.liftsCount =lifts;
        this.helper = helper;
        this.lifts = new Lift[lifts];
        for(int i=0;i<lifts;i++) this.lifts[i]= new Lift();
         helper.println("Lift system initialized ...");
    }

    /**
     * - This method should return index of lift which is assigned to user
     * 0 <= lift index < lifts.
     * - It will return -1 on failure to assign any lift to user.
     * - see Question details for cases when a lift can't be assigned to a user.
     */
    public int requestLift(int startFloor, int destinationFloor) {
        if(startFloor==destinationFloor) return -1;
        int liftId = -1;
        int timeToReachStart=1000*1000;
        char direction = startFloor<destinationFloor?'U':'D';
        for(int currentLiftIndex = 0; currentLiftIndex< liftsCount; currentLiftIndex++){
            Lift lift = lifts[currentLiftIndex];
            int reachStart = lift.getTimeToReachFloor(startFloor, direction);
            int reachDestination = lift.getTimeToReachFloor(destinationFloor, direction);
            if(reachStart<0 || reachDestination<0 || reachStart>timeToReachStart) continue;
            if(!lift.hasSpace(startFloor, destinationFloor)) continue;
            if(reachStart<timeToReachStart){
                liftId=currentLiftIndex;
                timeToReachStart=reachStart;
            }
        }
        if(liftId>=0 && liftId< liftsCount)
            lifts[liftId].addRequest(startFloor, destinationFloor);
        return liftId;
    }

    /**
     * This method is called every second
     * so that lift states can be appropriately updated.
     * we use this time rather than java.util.Date().time
     */
    public void tick() {
        for(int i = 0; i< liftsCount; i++)
            lifts[i].updateLiftState();
    }

    /**
     * returns list of lift indexes
     * which are going to stop on the given floor,
     * based on requests till now.
     * moveDirection : U for up, D for down, I for idle
     */
    public List<Integer> getLiftsStoppingOnFloor(
            int floor, char moveDirection) {
        List<Integer> liftIds = new ArrayList<Integer>();
        for(int i = 0; i< liftsCount; i++)
            if(lifts[i].hasStop(floor,moveDirection))
                liftIds.add(i);
        return liftIds;
    }

    // returns how many people are on a given lift right now.
    public int getNumberOfPeopleOnLift(int liftId){
        if(liftId<0||liftId>= liftsCount) return 0;
        return lifts[liftId].countPeople(
                lifts[liftId].getCurrentFloor(),
                lifts[liftId].getMoveDirection());
    }

    public String[] getLiftStates() {
        String liftStates[]=new String[liftsCount];
        for(int i = 0; i< liftsCount; i++){
            liftStates[i]=""+ lifts[i].getCurrentFloor()
                    +'-'+ lifts[i].getMoveDirection();
        }
        return liftStates;
    }

}
