/*
Input: 
4
93
97
94
99

Output: 
1
1
1
0

Explanation:

100 - (0 * 3 + 1 * 7) = 93, so the output is 1.

100 - (1 * 3 + 0 * 7) = 97, so the output is 1.

100 - (2 * 3 + 0 * 7) = 96, so the output is 1.

It is not possible, so the output is 0.


*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read number of test cases
        int T = scanner.nextInt();

        // Iterate over each test case
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            boolean possible = false;
            // Calculate the target amount to match using Rs 3 and Rs 7
            int target = 100 - N;

            // Iterate over possible numbers of Rs 3 chocolates
            for (int a = 0; a <= target / 3; a++) {
                // Check if the remaining amount after using Rs 3 chocolates can be divided by 7
                if ((target - 3 * a) % 7 == 0 && (target - 3 * a) >= 0) {
                    possible = true;
                    break;
                }
            }

            // Output result for the current test case
            if (possible) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        scanner.close();
    }
}
