package sample;

public class StudentMember extends Member {
    private String schoolName;

    public StudentMember(){

    }

    public StudentMember(int memberID, String memberName, String startMembershipDate, String schoolName) {
        super(memberID, memberName, startMembershipDate);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "StudentMember{" +
                "schoolName='" + schoolName + '\'' +
                '}';
    }
}
