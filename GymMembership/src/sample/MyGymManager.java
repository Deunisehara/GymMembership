package sample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Scanner;

public class MyGymManager implements GymManager {
    Scanner scan = new Scanner(System.in);
    Member defaultMember = new Member();
    StudentMember studentMember = new StudentMember();
    AdultMembers adultMembers = new AdultMembers();
    Mongodb database = new Mongodb();
    private String memberCatergory;
    private String memberName;
    private String memberAge;
    private String memberSchool;
    private String startDate;
    private ArrayList<String> memberDetails = new ArrayList<String>();
    DateTimeFormatter localDate;



    @Override
    public void addMember(String catergoryName) {
        System.out.println("####### Enter the catergory #######\nm- For Normal Member\nS- Student Member\nA- Adult Member");
        System.out.println("Enter the value - ");
        catergoryName = scan.nextLine().toLowerCase();
        System.out.println("\nEnter the your full name : ");
        LocalDate date = LocalDate.now();
        memberName = scan.nextLine().toLowerCase();
        defaultMember.setMemberName(memberName);
        startDate = DateTimeFormatter.ofPattern("yyy/MM/dd").format(date);
        memberDetails.add(memberName);
        memberDetails.add(catergoryName);
        memberDetails.add(startDate);

        if(catergoryName.equals("s")){
            System.out.println("\nEnter the your school : ");
            memberSchool = scan.nextLine().toLowerCase();
            memberDetails.add(memberSchool);
        }else if(catergoryName.equals("a")){
            System.out.println("\nEnter the your age : ");
            memberAge = scan.nextLine().toLowerCase();
            memberDetails.add(memberAge);
        }
        database.addingMemberData(memberDetails);


    }

    @Override
    public void deleteMember() {
        System.out.println("\n------Enter Catergory that you want delete-------\nm-Normal Member\ns-Student\na-Adult Member ");
        String deleteCatergory = scan.nextLine().toLowerCase();
        System.out.println("\nEnter the member name that you want to delete : ");
        String deleteMember = scan.nextLine().toLowerCase();
        database.deleteMember(deleteCatergory,deleteMember);

    }

    @Override
    public void updateMember() {
        System.out.println("######Enter the Member Name that you want to Edit#######");
        memberName  = scan.nextLine().toLowerCase();
        System.out.println("\n----- Catergory of the Member ------\nm-Normal Member\ns-Student\na-Adult Member");
        memberCatergory = scan.nextLine().toLowerCase();
        System.out.println("\nEnter what you want to edit : \nN- name\nA-Age\nS-School");
        String editCatergory = scan.nextLine().toLowerCase();
        if(editCatergory.equals("n")||editCatergory.equals("a")||editCatergory.equals("s")){
            System.out.println("\nEnter the new Value : ");
            String editedValue = scan.nextLine().toLowerCase();
            database.updatingMemberData(memberName,memberCatergory,editCatergory,editedValue);
        }else {
            System.out.println("Invalid Input");
        }


    }

    @Override
    public void viewMember() {
        database.gettingMemberData();
    }
}
