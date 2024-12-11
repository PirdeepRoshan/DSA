/*
Sample Input 0
(()()())
Sample Output 0
true
Sample Input 1
()()(()
Sample Output 1
false
*/
import java.io.*;
import java.util.*;

public class Solution {

     public static boolean isBalanced(String expr) {
     Stack<Character> stack = new Stack<Character>();
     for (int i = 0; i < expr.length(); i++)
     {
        char c = expr.charAt(i); // (
        if (c == '(') {
            stack.push(c);
        }else if (c == ')') {
           if(stack.isEmpty())
           {
                return false;
           } 
           else{
              stack.pop();
              }
            }
         }
         return stack.isEmpty();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        boolean result = isBalanced(expr);
        System.out.println(result);

    }
}
