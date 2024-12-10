/*
Input:

1230

Output:

1000 100 100 20 10  
*/
import java.util.*;

public class Main {
    // Denominations available in Indian currency
    static int[] denominations = {1000, 500, 100, 50, 20, 10, 5, 2, 1};

    public static void findMinCoins(int N) {
        List<Integer> result = new ArrayList<>();

        // Iterate through all denominations
        for (int i = 0; i < denominations.length; i++) {
            // Find the maximum number of coins/notes of this denomination
            while (N >= denominations[i]) {
                N= N-  denominations[i];
                result.add(denominations[i]);
            }
        }

        // Print the result
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + "  ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        findMinCoins(N);
    }
}
