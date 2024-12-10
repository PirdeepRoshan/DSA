/*
Input:
2
5
4 1 3 9 7
10
10 9 8 7 6 5 4 3 2 1
Output:
1 3 4 7 9
1 2 3 4 5 6 7 8 9 10
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt(); // Read number of test cases
        
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Read the size of the array
            int[] array = new int[N];
            
            // Read the array elements
            for (int i = 0; i < N; i++) {
                array[i] = scanner.nextInt();
            }
            
            // Perform Selection Sort
            selectionSort(array, N);
            
            // Print the sorted array
            for (int i = 0; i < N; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println(); // Move to the next line after each test case
        }
        
        scanner.close();
    }
    
    public static void selectionSort(int[] array, int N) {
        // Traverse through all elements in the array
        for (int i = 0; i < N - 1; i++) {
            // Find the minimum element in the unsorted part of the array
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap the found minimum element with the first element of the unsorted part
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
