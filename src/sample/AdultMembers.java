package sample;

public class AdultMembers extends Member {
    private int age;

    public AdultMembers() {

    }

    public AdultMembers(int memberID, String memberName, String startMembershipDate, int age) {
        super(memberID, memberName, startMembershipDate);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AdultMembers{" +
                "age=" + age +
                '}';
    }
}
