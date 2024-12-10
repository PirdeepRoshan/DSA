/*
Sample Input 1

5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1

6

*/

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Node> queue = new LinkedList<>();
        int c = 0;

        // Read the root node value
        int x = sc.nextInt();
        Node head = null;

        if (x != -1) {
            head = new Node(x);
            queue.add(head);
            c++;
        }

        // Build the tree
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            // Read left child value
            x = sc.nextInt();
            if (x != -1) {
                temp.left = new Node(x);
                queue.add(temp.left);
                c++;
            }

            // Read right child value
            int y = sc.nextInt();
            if (y != -1) {
                temp.right = new Node(y);
                queue.add(temp.right);
                c++;
            }
        }

        // Output the number of nodes
        System.out.println(c);
    }
}
