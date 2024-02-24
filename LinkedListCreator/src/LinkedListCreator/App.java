package LinkedListCreator;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.ListIterator;

/**
 * Main class to allow the user to input 5 integers, store them in a sorted
 * linked list while adding them, and then eventually printed the sorted
 * linked list back to the user.
 * 
 * The program makes use of the LinkedList, ListIterator, and Scanner packages.
 * 
 * To run the program in the terminal navigate to the src folder 
 * and run two commands, `javac LinkedListCreator/App.java` 
 * and then `java LinkedListCreator/App`.
 * 
 * To generate javadocs navigate to the doc folder (first create one if it 
 * has not been created yet) and run `javadoc ../src/LinkedListCreator/App.java`
 * 
 * @author Jimmy Shultz
 * @version 1.1
 * @since 1.0
 */
public class App {
    
    /**
     * Default contructor used for intilization of the class becuase no 
     * customization is needed.
     */
    public App () {}

    /**
     * Main method of the class calling the getIntegerInput and addSortedNumber
     * methods.
     * @param args command line arguments are unused in the program.
     */
    public static void main(String[] args) {
        
        LinkedList<Integer> numbers = new LinkedList<>();
        System.out.println(
            "Please enter 5 integers to be sorted in a linked list");
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            int convertedNumber = getIntegerInput(sc);
            addSortedNumber(numbers, convertedNumber);
        }

        sc.close();

        System.out.println(numbers);
        
    }

    /**
     * Prompts the user for input and returns an integer.
     * @param scanner the scanner that allows for user input
     * @return the user input as an integer
     */
    public static int getIntegerInput(Scanner scanner) {

        System.out.println("Enter an integer:");
        int convertedNumber = 0;

        while (true) {
            String userInput = scanner.nextLine();

            try {
                convertedNumber = Integer.parseInt(userInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid integer.");
            }
        }

        return convertedNumber;
    }

    /**
     * Adds a number to a linked list while ensuring the linked list stays 
     * sorted.
     * @param pNumbers the current linked list
     * @param addedNumber the number to be added
     */
    public static void addSortedNumber(
        LinkedList<Integer> pNumbers, int addedNumber) {
        
        ListIterator<Integer> iterator = pNumbers.listIterator();

        while (iterator.hasNext()) {
            int currentNumber = iterator.next();
            if (addedNumber < currentNumber) {
                iterator.previous();
                iterator.add(addedNumber);
                return;
            }
        }
        iterator.add(addedNumber);
    }
}
