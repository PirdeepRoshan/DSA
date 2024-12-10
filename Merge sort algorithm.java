/*
Input:

6

11 15 26 38 9 10 

Output:

9 10 11 15 26 38
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        
        // Apply Quicksort to the array
        quickSort(array, 0, array.length - 1);
        
        // Print the sorted array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        
        scanner.close();
    }

    // Quicksort method
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(array, low, high);
            
            // Recursively apply Quicksort to the partitions
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // Partition method for Quicksort
    public static int partition(int[] array, int low, int high) {
        // Choose the rightmost element as the pivot
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (array[j] <= pivot) {
                i++;
                // Swap array[i] with array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap the pivot element with the element at i + 1
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
