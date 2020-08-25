import java.util.Scanner;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        //var ini
        String userInput = "";
        boolean flag = true;

        String fName,lName,id;
        LinkedList studentManagementSystem = new LinkedList();
        studentManagementSystem.loadDataFromFile(studentManagementSystem);//loading prevoise data from file
        while(flag == true)
        {
            System.out.println("\t\t\t ----- LINKED LIST OPERATIONS -----");
            System.out.println("1. Add New student record ");
            System.out.println("2. Delete student record ");
            System.out.println("3. Update Student record");
            System.out.println("4. Search record");
            System.out.println("5. Display all record");
            System.out.println("6. EXIT");


            System.out.println("\nEnter your choice: ");
            userInput = scanner.nextLine();


            switch(userInput)
            {
                case "1":

                    System.out.println("Enter Student First Name: ");
                    fName = scanner.nextLine();
                    System.out.println("Enter Student Last Name: ");
                    lName = scanner.nextLine();
                    System.out.println("Enter Student ID: ");
                    id = scanner.nextLine();
                    boolean yes = id.matches("^((?:[A-Z]{2})?\\d{2})-+(.+?)-(\\d{4})$");
                    if (yes){
                        studentManagementSystem.insertNewRecord(new Student(fName,lName,id));
                    }
                    else{
                        System.out.println(" Incorrect ID Format\n Try Again ");
                    }
                    break;

                case "2":
                    System.out.println("Enter Student ID: ");
                    id = scanner.nextLine();
                    studentManagementSystem.deleteRecord(id);
                    break;

                case "3":
                    System.out.println("Enter Student Student ID that you want to update: ");
                    id = scanner.nextLine();
                    System.out.println("Enter Student First Name: ");
                    fName = scanner.nextLine();
                    System.out.println("Enter Student Last Name: ");
                    lName = scanner.nextLine();
                    studentManagementSystem.update(id,new Student(fName,lName,id));
                    break;

                case "4":
                    System.out.println("Enter Student Id to find: ");
                    id = scanner.nextLine();
                    if(studentManagementSystem.search(id)) {
                        System.out.println("Given ID exists");
                    }else {
                        System.out.println("This record does not exist");
                    }
                    break;

                case "5":
                    studentManagementSystem.displayAllRecord();
                    break;

                case "6":
                    flag =false;
                    studentManagementSystem.savaRecordInFile();
                    break;

                default:
                    System.out.println("Enter Correct Choice");
                    break;


            }
        }


        //System.out.println(); // deubug perpose



    }
}
