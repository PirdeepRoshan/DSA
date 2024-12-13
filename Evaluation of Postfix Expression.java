/*
Input:
2
231*+9-
123+*8-

Output:
-4
-3

Explanation: 
Test Case 1: 
231*+9-
- : ( ) - ( )
9 : ( ) - (9)
+ : ( ( ) + ( ) ) - (9)
*: ( ( ) + ( ( ) * ( ) ) ) - (9)
1 : ( ( ) + ( ( ) * (1) ) ) - (9)
3 : ( ( ) + ( (3) * (1) ) ) - (9)
2 : ( (2) + ( (3) * (1) ) ) - (9) 
Result = (2 + 3) - 9 = 5 - 9 = -4
Test Case 2: 
123+*8-
- : ( ) - ( )
8 : ( ) - (8)
* : ( ( ) * ( ) ) - (8)
+ : ( ( ) * ( ( ) + ( ) ) ) - (8)
3 : ( ( ) * ( ( ) + (3) ) ) - (8)
2 : ( ( ) * ( (2) + (3) ) ) - (8)
1 : ( (1) * ( (2) + (3) ) ) - (8) 
Result = (1 * 5) - 8 = 5 - 8 = -3
*/
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        for (int i = 0; i < T; i++) {
            String postfixExpression = scanner.nextLine();
            System.out.println(evaluatePostfix(postfixExpression));
        }

        scanner.close();
    }
}
