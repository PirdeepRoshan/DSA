/*
Input (stdin)
2
00001
0

Output (stdout)
4
-1
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of test cases
        int T = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Process each test case
        for (int i = 0; i < T; i++) {
            String s = scanner.nextLine();
            
            // Find the last index of '1'
            int lastIndex = s.lastIndexOf('1');
            
            // Print the result
            System.out.println(lastIndex);
        }
        
        scanner.close();
    }
}
