import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Scanner;

public class IntermediateElizaApp {
    public static void main(String[] args) {
        /*
        1. import Scanner
        2. Display welcome message
        3. Assign user input to a variable
        4. Split input and loop through the array to find
        specific words to be replaced and have eliza respond
        using new String with replacements.
        5. Initiate loop under the condition that the user
        does not enter either 'q' or 'I am feeling great'.
        6. if the user enters 'I am feeling great' display
        appropriate message before ending program.
         */

        Scanner scn = new Scanner(System.in);
        //imports local date and time, can pull individual day/hour/month/year with .get
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("Enter your first name: ");
        String userName = scn.nextLine();
        String userResponseSplit[];
        String userResponseRep;
        //using .getHour() from local date time to print the
        //appropriate message given the time of the day
        if (localDateTime.getHour() < 12) {
            System.out.println("Good morning " + userName);
        } else {
            System.out.println("Good afternoon " + userName);
        }

        //ElizaChat actually begins
        System.out.println("Welcome to ElizaChats, the #1 Yelp reviewed online therapist.\nNow, what can I help you with today?");
        System.out.println("Enter response here or 'Q' to quit:");
        String userResponse = scn.nextLine();
        userResponseRep = wordReplace(userResponse);
        while ((!userResponse.equalsIgnoreCase("Q")) && (!userResponse.equalsIgnoreCase("I am feeling great"))) {
            System.out.println("What makes you say " + userResponseRep + "? Enter response here or 'Q' to quit:");
            userResponse = scn.nextLine();
            userResponse = wordReplace(userResponse);
        }
        //If userResponse is 'I am feeling great' display special message
        if (userResponse.equalsIgnoreCase("I am feeling great")){
            System.out.println("Another success by ElizaChats! I will do you a favor and submit a Yelp review in your name.\nThank you "+userName+" :)");
        }
    }

    public static String wordReplace(String userResponse) {
        String userResponseSplit[] = userResponse.split(" ");
        String userResponseRep = "";
        for (int i = 0; i < Array.getLength(userResponseSplit); i++) {
            if ((userResponseSplit[i].equalsIgnoreCase("I")) || (userResponseSplit[i].equalsIgnoreCase("me"))) {
                userResponseSplit[i] = "you";
            } else if (userResponseSplit[i].equalsIgnoreCase("my")) {
                userResponseSplit[i] = "your";
            } else if (userResponseSplit[i].equalsIgnoreCase("am")) {
                userResponseSplit[i] = "are";
            }
            userResponseRep += userResponseSplit[i]+" ";
        }
        return userResponseRep;}
}
