package L5.SList;

import java.util.Scanner;
public class L5Q2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        SList<String> list = new SList<String>();
        enterName(list);
        rename(list);
        removeName(list);
        System.out.println("All student data captured.");
    }

    static void dispStats(SList<String> list) {
        System.out.println("\nYou have entered the following student names: ");
        list.display();
        System.out.println("The number of students entered is: " + list.getSize() + "\n");
    }

    static void enterName(SList<String> list) {
        System.out.println("Enter your student name list, enter 'n' to end: ");
        String name = " ";
        do {
            name = sc.nextLine();
            if (!name.equalsIgnoreCase("n")) {
                list.appendEnd(name);
            }
        } while (!name.equalsIgnoreCase("n"));
        dispStats(list);
    }


    static void rename(SList<String> list) {
        do {
            System.out.println("All the names entered are correct? Enter 'r' to rename the student name, 'n' to proceed.");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("r")) {
                System.out.println("Enter the student name to be renamed: ");
                String oldName = sc.nextLine();
                System.out.println("Enter the new name: ");
                String newName = sc.nextLine();
                list.replace(oldName, newName);
                dispStats(list);
            } else if (choice.equalsIgnoreCase("n")){
                return;
            } else {
                System.out.println("Invalid input, please enter 'r' to rename the student name, 'n' to proceed.");
            }
        } while (true);
    }

    static void removeName(SList<String> list) {
        do {
            System.out.println("Do you want to remove any student name? Enter 'y' to remove, 'n' to proceed.");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                System.out.println("Enter the student name to be removed: ");
                String name = sc.nextLine();
                list.removeElement(name);
                dispStats(list);
            } else if (choice.equalsIgnoreCase("n")){
                dispStats(list);
                return;
            } else {
                System.out.println("Invalid input, please enter 'y' to remove the student name, 'n' to proceed.");
            }
        } while (true);
    }
}
