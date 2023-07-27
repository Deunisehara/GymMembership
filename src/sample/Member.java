package sample;

public class Member {

    private int memberID;
    private String memberName;
    private String startMembershipDate;


    public Member(int memberID, String memberName, String startMembershipDate) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.startMembershipDate = startMembershipDate;
    }

    public Member() {
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getStartMembershipDate() {
        return startMembershipDate;
    }

    public void setStartMembershipDate(String startMembershipDate) {
        this.startMembershipDate = startMembershipDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberID=" + memberID +
                ", memberName='" + memberName + '\'' +
                ", startMembershipDate=" + startMembershipDate +
                '}';
    }
}
