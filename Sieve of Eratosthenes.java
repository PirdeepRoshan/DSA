/*
Input:
10

Output:
2 3 5 7

Explanation:

Prime numbers less than or equal to 10 are 2, 3, 5, and 7.
*/

import java.util.*;
public class Main {
static void sieveOfEratosthenes(int limit) {
boolean[] isPrime = new boolean[limit + 1];
Arrays.fill(isPrime, true);
for (int i = 2; i * i <= limit; i++) {
if (isPrime[i]) {
for (int j = i * i; j <= limit; j += i) {
isPrime[j] = false;
}
}
}
// Print the prime numbers
//System.out.print("Prime numbers up to " + limit + ": ");
for (int i = 2; i <= limit; i++) {
if (isPrime[i]) {
System.out.print(i + " ");
}
}
System.out.println();
}
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int limit = sc.nextInt(); // You can change this limit to find prime numbers up to a different

sieveOfEratosthenes(limit);
}
}
