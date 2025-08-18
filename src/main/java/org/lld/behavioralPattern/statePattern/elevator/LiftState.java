package org.lld.behavioralPattern.statePattern.elevator;

abstract public class LiftState {
        protected Lift lift;
        LiftState(Lift lift){
            this.lift=lift;
        }
        public void updateFloor(){}
        public void updateDirection(){}
        public abstract char getDirection();
        public abstract int getTimeToReachFloor(int floor, char direction);
}
