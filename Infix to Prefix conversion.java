/*
Input:

(5-6)*7

Output:

*-567
*/
import java.util.*;

public class Main {

    // Function to determine the precedence of operators
    public static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    // Function to reverse a string
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // Function to swap parentheses
    public static String swapParentheses(String s) {
        return s.replace('(', ']').replace(')', '(').replace(']', ')');
    }

    // Function to convert infix expression to postfix expression
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (Character.isDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // pop '('
            } else { // operator
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    // Function to convert infix expression to prefix expression
    public static String infixToPrefix(String infix) {
        // Step 1: Reverse the infix expression
        String reversedInfix = reverseString(infix);

        // Step 2: Swap parentheses
        String swappedInfix = swapParentheses(reversedInfix);

        // Step 3: Convert the modified infix to postfix
        String postfix = infixToPostfix(swappedInfix);

        // Step 4: Reverse the postfix expression to get prefix
        return reverseString(postfix);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infix = sc.nextLine();
        sc.close();

        // Convert infix expression to prefix expression
        String prefix = infixToPrefix(infix);
        System.out.println(prefix);
    }
}
