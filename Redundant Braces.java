/*
Input:

((a+b))

Output:

Yes

Input (stdin)
(a+b*(c-d))

Output (stdout)
No
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        
        boolean result = hasRedundantBraces(expr);
        
        if (result) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        sc.close();
    }
    
    public static boolean hasRedundantBraces(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            // Push operators and opening braces into the stack
            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                stack.push(ch);
            } else if (ch == ')') {
                boolean operatorFound = false;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        operatorFound = true;
                    }
                }
                // Pop the opening brace
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                
                // If no operator was found between the braces, they are redundant
                if (!operatorFound) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
