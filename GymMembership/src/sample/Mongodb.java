package sample;

import com.mongodb.*;
import java.net.UnknownHostException;
import java.util.ArrayList;



public class Mongodb {
    StudentMember studentMember = new StudentMember();
    Member defaultMember = new Member();
    private ArrayList<DBObject> gymMemeberData = new ArrayList<DBObject>();

//    AdultMembers adultMembers = new AdultMembers();
    MongoClient mongoClient;

    {
        try {
            mongoClient = new MongoClient( "localhost" , 27017 );
            System.out.println("connection successful");
        } catch (UnknownHostException e) {
            System.out.println("error in connection.......");
        }
    }

    DB db = mongoClient.getDB("Gym_Management");
    DBCollection defaultMembers = db.getCollection("Members");
    DBCollection schoolMembers = db.getCollection("SchoolMembers");
    DBCollection adultMembers = db.getCollection("AdultMembers");


    //adding data....
    public void addingMemberData(ArrayList<String> memberDetails){
        BasicDBObject addMemberDetails = new BasicDBObject();
        addMemberDetails.put("memberName",memberDetails.get(0));
        addMemberDetails.put("Start Date",memberDetails.get(2));

        if(memberDetails.get(1).equals("s")){
            addMemberDetails.put("School Name",memberDetails.get(3));
            schoolMembers.insert(addMemberDetails);
        }else if(memberDetails.get(1).equals("a")){
            System.out.println("the list for adult : "+memberDetails);
            addMemberDetails.put("Age",memberDetails.get(3));
            adultMembers.insert(addMemberDetails);
        }else if(memberDetails.get(1).equals("m")) {
            defaultMembers.insert(addMemberDetails);
        }else{
            System.out.println("\nInvalid data entered. Please check again");
        }
        System.out.println("\n......Data inserted successfully.....");

    }
    // getting the collections
    public void gettingMemberData(){
        DBCursor cursor = defaultMembers.find();

        while (cursor.hasNext()) {
            gymMemeberData.add(cursor.next());
            System.out.println(gymMemeberData.get(0));
        }
    }
    public void updatingMemberData(String memberName,String catergoryName,String editCatergory,String editValue){
        BasicDBObject updateMember = new BasicDBObject();
        BasicDBObject oldDetails = new BasicDBObject().append("memberName",memberName);

        System.out.println("Database updated...");

        if(catergoryName.equals("m")){
            updateMember.append("$set",new BasicDBObject().append("memberName",editValue));
            defaultMembers.update(oldDetails,updateMember,false,false);
        }else if(catergoryName.equals("s")){
            if(editCatergory.equals("n")){
                updateMember.append("$set",new BasicDBObject().append("memberName",editValue));
            }else{
                updateMember.append("$set",new BasicDBObject().append("School Name",editValue));
            }
            schoolMembers.update(oldDetails,updateMember,false,false);
        }else if(catergoryName.equals("a")){
            if(editCatergory.equals("n")){
                updateMember.append("$set",new BasicDBObject().append("memberName",editValue));
            }else{
                updateMember.append("$set",new BasicDBObject().append("Age",editValue));
            }
            adultMembers.update(oldDetails,updateMember,false,false);
        }else {
            System.out.println("\nEntered Catergory is Invalid......");
        }
    }
    public void deleteMember(String catergoryName,String memeberName){
        BasicDBObject deleMemberDetails = new BasicDBObject("memberName",memeberName);

        if(catergoryName.equals("m")){
            findAndDelete(defaultMembers,deleMemberDetails,memeberName);
        }else if(catergoryName.equals("s")){
            findAndDelete(schoolMembers,deleMemberDetails,memeberName);
        }else if(catergoryName.equals("a")){
            findAndDelete(adultMembers,deleMemberDetails,memeberName);
        }else{
            System.out.println("You have entered a invalid catergory");
        }
    }

    public void findAndDelete(DBCollection collection,BasicDBObject getDocuments,String memeberName){
        BasicDBObject memberDelete;
        Cursor cursor = collection.find(getDocuments);
        while (cursor.hasNext()) {
            memberDelete = (BasicDBObject) cursor.next();
            System.out.println(memberDelete);
        }
        System.out.println("\nMember Removed successfully.");
    }


}
