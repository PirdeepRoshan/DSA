/*
Input:

face

Output:

ecaf
*/

import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        String inputString = scanner.nextLine();

        // Create a stack to hold characters
        Stack<Character> stack = new Stack<>();

        // Push all characters of the string into the stack using a normal for loop
        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
        }

        // Pop characters from the stack to reverse the string
        String reversedString = "";
        while (!stack.isEmpty()) {
            reversedString += stack.pop();
        }

        // Output the reversed string
        System.out.println(reversedString);

        // Close the scanner
        scanner.close();
    }
}
