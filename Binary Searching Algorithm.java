/*
Input:

4

23

34

43

54

23

Output:

23 is present at location 1
*/
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();        
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int key = scanner.nextInt();

        // Ensure the array is sorted for binary search
        Arrays.sort(array);

        int result = binarySearch(array, key);

        if (result == -1) {
            // Output the expected "Not found" message
            System.out.println("Not found");
        } else {
            System.out.println(key + " is present at location " + (result + 1));
        }

        scanner.close();
    }

    public static int binarySearch(int[] array, int key) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid =(left + right)/2;

            if (array[mid] == key) {
                return mid;
            }

            if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
