/*
Input:

6

11 15 26 38 9 10

10 

Output:

10 is present at location 6.
*/

import java.util.*;

class Main {
    public static void linearsearch(int a[], int n, int m) {
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (a[i] == m) {
                System.out.println(m + " is present at location " + (i + 1) + ".");
                found = true;
                break;  // Exit loop once the element is found
            }
        }
        if (!found) {
            System.out.println("Not found");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        // Input array size
        int n = sc.nextInt();
        
        // Input array elements
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        // Input the element to search
        int m = sc.nextInt();
        
        // Perform the search
        linearsearch(a, n, m);
    }
}
