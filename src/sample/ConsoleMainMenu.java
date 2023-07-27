package sample;

import java.util.Scanner;

public class ConsoleMainMenu {

    public static void main(String[] args) {
        MyGymManager myGymManager = new MyGymManager();
        Scanner scanner = new Scanner(System.in);
        boolean loopValue = true;
        System.out.println("Gym Management system.....");


        // infinte loop for getting the users correct value...
        do{
            System.out.println("\n-----------Select the a letter to Continue-----------");
            System.out.println("\nA - Adding a New Member\nV - Viewing Members \nU - Updating Members \nD - Deleting Members");
            System.out.println("--Enter the letter : ");
            String userInput = scanner.nextLine().toLowerCase();

            switch (userInput) {
                case "a":
                    myGymManager.addMember(userInput);
                    break;
                case "v":
                    myGymManager.viewMember();
                    break;
                case "u":
                    myGymManager.updateMember();
                    break;
                case "d":
                    myGymManager.deleteMember();
                    break;
                default:
                    System.out.println("Entered value is not Valid please enter a valid value");
            }
        }
        while(loopValue == true);

//        Mongodb mongodb = new Mongodb();

//       AddMember addMember = new AddMember();

    }
}
