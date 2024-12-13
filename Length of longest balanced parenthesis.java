/*
Input (stdin)
()()

Output (stdout)
4

Input (stdin)
(((())()(()

Output (stdout)
6
*/
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String parentheses = sc.nextLine();
        
        int maxLength = findLongestBalancedParentheses(parentheses);
        
        System.out.println(maxLength);
        
        sc.close();
    }

    public static int findLongestBalancedParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // Base to handle the edge case for first valid substring
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}
