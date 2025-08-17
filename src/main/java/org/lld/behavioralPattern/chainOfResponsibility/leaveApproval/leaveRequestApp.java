package org.lld.behavioralPattern.chainOfResponsibility.leaveApproval;
enum ReasonType{
    REGULAR , CRITICAL,SPECIAL
}
class Leave{
    private int numOfDays;
    private int empTier;
    private ReasonType reason;

    public Leave(int numOfDays,int empTier, ReasonType reason){
        this.numOfDays = numOfDays;
        this.empTier = empTier;
        this.reason = reason;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public ReasonType getReason() {
        return reason;
    }

    public int getEmpTier() {
        return empTier;
    }
}

abstract class LeaveHandler{
    protected LeaveHandler superVisor;
    public void setSuperVisor(LeaveHandler superVisor){
        this.superVisor = superVisor;
    }
    public abstract String applyLeave(Leave leave);
}


class TeamLeader extends LeaveHandler{
    @Override
    public String applyLeave(Leave leave){
        if(leave.getNumOfDays() <= 7){
            if(leave.getEmpTier() <=4){
                return "Your leave days has been APPROVED by TeamLeader";
            }else{
                return "You employee Tier level is too low for request " + leave.getNumOfDays() + " days";
            }
        }
        else{
            return superVisor.applyLeave(leave);
        }
    }
}

class ProjectLeader extends LeaveHandler {

    @Override
    public String applyLeave(Leave leave) {

        //"reasonType" is not going to be consider under TeamLeader & ProjectLeader
        //Project Leader can approve up to 14 days, otherwise it will pass to the HR
        if(leave.getNumOfDays() <= 14){
            //Employee tier should be 3 or above to get approved
            if(leave.getEmpTier() <= 3){
                return "Your leave days has been APPROVED by Project Leader";
            }else{
                return "You employee Tier level is too low for request " + leave.getNumOfDays() + " days";
            }
        }else{
            return superVisor.applyLeave(leave);
        }
    }
}
class HR extends LeaveHandler {

    @Override
    public String applyLeave(Leave leave) {

        //HR can approve up to 21 days, otherwise it will pass to the Manager
        if(leave.getNumOfDays() <= 21){
            //Employee tier should be 3 or above & reason type should not be "Regular" to get approved
            if(leave.getEmpTier() <= 3 && !leave.getReason().equals(ReasonType.REGULAR)){
                return "Your leave days has been APPROVED by HR";
            }else{
                return "Your leave request has been DENIED by HR";
            }
        }else{
            return superVisor.applyLeave(leave);
        }
    }
}
class Manager extends LeaveHandler {

    @Override
    public String applyLeave(Leave leave) {

        //Only Manager has the authority to approve more than 21 days
        if (leave.getNumOfDays() > 21) {
            //Employee tier should be 2 or above & reason type should be "Special" to get approved
            if (leave.getEmpTier() <= 2 && leave.getReason().equals(ReasonType.SPECIAL)) {
                return "Your leave days has been APPROVED by Manager";
            }
        }
        return "Your leave request has been DENIED by Manager";
    }
}

public class leaveRequestApp {
    public static void main(String[] args) {
        TeamLeader teamLeader = new TeamLeader();
        ProjectLeader projectLeader = new ProjectLeader();
        HR hr = new HR();
        Manager manager = new Manager();
        teamLeader.setSuperVisor(projectLeader);
        projectLeader.setSuperVisor(hr);
        hr.setSuperVisor(manager);

        Leave leave1 = new Leave(5,4, ReasonType.REGULAR);
        System.out.println(teamLeader.applyLeave(leave1));

        Leave leave2 = new Leave(5,5, ReasonType.REGULAR);
        System.out.println(teamLeader.applyLeave(leave2));

        Leave leave3 = new Leave(12,3, ReasonType.REGULAR);
        System.out.println(teamLeader.applyLeave(leave3));

        Leave leave4 = new Leave(18,2, ReasonType.CRITICAL);
        System.out.println(teamLeader.applyLeave(leave4));

        Leave leave5 = new Leave(18,2, ReasonType.REGULAR);
        System.out.println(teamLeader.applyLeave(leave5));

        Leave leave6 = new Leave(30,2, ReasonType.SPECIAL);
        System.out.println(teamLeader.applyLeave(leave6));
    }
}
