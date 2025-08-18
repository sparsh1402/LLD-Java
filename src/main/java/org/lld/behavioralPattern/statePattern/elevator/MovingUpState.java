package org.lld.behavioralPattern.statePattern.elevator;

public class MovingUpState extends LiftState {
        MovingUpState(Lift lift) {
            super(lift);
        }

        public int getTimeToReachFloor(int floor, char direction) {
            int currentFloor = lift.getCurrentFloor();
            boolean hasStopOpposite = lift.hasStopInOppositeDirection();
            int maxUpFloor = getMaxUpFloor();
            // NOT ELIGIBLE: there are requests in opposite direction
            if (floor > maxUpFloor && hasStopOpposite) return -1;
            if (direction == 'U') {
                if (floor == currentFloor) return 0;
                // NOT ELIGIBLE : lift has already passed floor
                if (floor < currentFloor) return -1;
                int timeTaken = floor - currentFloor;
                return timeTaken;
            }
            if (floor >= maxUpFloor) {
                int timeTaken = floor - currentFloor;
                return timeTaken;
            }
            int time = maxUpFloor - currentFloor + maxUpFloor - floor;
            return time;
        }


        private int getMaxUpFloor(){
            int floor = -1;
            for(LiftRequest request: lift.getRequests()){
                if(floor<request.getStartFloor())
                    floor= request.getStartFloor();
                if(floor<request.getDestinationFloor())
                    floor = request.getDestinationFloor();
            }
            return floor;
        }

        public void updateFloor() {
            int maxUpFloor = getMaxUpFloor();
            if(lift.getCurrentFloor()<maxUpFloor) {
                lift.setCurrentFloor(lift.getCurrentFloor() + 1);
            }
        }

        public void updateDirection(){
            if(lift.getCurrentFloor()>=getMaxUpFloor())
                lift.setState('D');
        }

        public char getDirection() {
            return 'U';
        }

    }
