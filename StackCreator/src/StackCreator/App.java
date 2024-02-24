package StackCreator;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.ListIterator;
import java.util.Stack;

/**
 * Main class to allow the user to input 5 integers, store them in a sorted
 * linked list while adding them, push the elements of the linked list onto 
 * a stack in order from smallest to largest, and then pop the largest 
 * while printing it to the terminal.
 * 
 * The program makes use of the LinkedList, ListIterator, Stack, and Scanner 
 * packages.
 * 
 * To run the program in the terminal navigate to the src folder and run two
 * command `javac StackCreator/App.java` and then `java StackCreator/App`.
 * 
 * To generate javadocs navigate to the doc folder and run 
 * `javadoc ../src/StackCreator/App.java`
 * 
 * @author Jimmy Shultz
 * @version 1.2
 * @since 1.2
 */
public class App {
    /**
     * Default contructor used for intilization of the class becuase no 
     * customization is needed.
     * @since 1.1
     */
    public App () {}
    
    /**
     * Main method of the class calling the getIntegerInput, addSortedNumber, 
     * and pushLinkedListToStack methods for the length of the list 
     * (which is currently 5).  Then popping each integer off the stack 
     * and printing it to the terminal.
     * 
     * @param args command line arguments are unused in the program.
     * @since 1.2
     */
    public static void main(String[] args) {
        
        LinkedList<Integer> numbers = new LinkedList<>();
        Stack<Integer> numbersStack = new Stack<>();
        Integer listLength = 5;

        System.out.println(
            "Please enter 5 integers to be sorted in a linked list");

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < listLength; i++) {
            int convertedNumber = getIntegerInput(sc);
            addSortedNumber(numbers, convertedNumber);
        }

        sc.close();

        for (int i = 0; i < listLength; i++) {
            pushLinkedListElementToStack(numbers, numbersStack);
        }

        System.out.println("");
        System.out.println("Your sorted stack from top to bottom is:");

        for (int i = 0; i < listLength; i++) {
            System.out.println(numbersStack.pop());
        }
        
    }

    /**
     * Prompts the user for input and returns an integer.
     * 
     * @param scanner the scanner that allows for user input
     * @return the user input as an integer
     * @since 1.0
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
     * 
     * @param pNumbers the current linked list
     * @param addedNumber the number to be added
     * @since 1.0
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

    /**
     * Removes the first element of a linked list of integers 
     * and pushes it onto a stack of integers.
     * 
     * @param pNumbers the sorted linked list to be drawn from
     * @param pNumbersStack the stack to be pushed to
     * @since 1.2
     */
    public static void pushLinkedListElementToStack (
        LinkedList<Integer> pNumbers, Stack<Integer> pNumbersStack) {
        
        int currentNumber = pNumbers.removeFirst();
        pNumbersStack.push(currentNumber);
    }
}
