/*
Input (stdin)
6
8 5 10 2 6 7
6
10

Output (stdout)
6 7 8 10
*/

import java.util.Scanner;

class Main {
    // Definition of Node class for the BST
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Function to insert a node into the BST
    public static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // In-order traversal function to print nodes in the range [k1, k2]
    public static void printRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        
        // If the current node's value is greater than k1, check left subtree
        if (root.data > k1) {
            printRange(root.left, k1, k2);
        }
        
        // Print current node's value if it's within the range
        if (root.data >= k1 && root.data <= k2) {
            System.out.print(root.data + " ");
        }
        
        // If the current node's value is less than k2, check right subtree
        if (root.data < k2) {
            printRange(root.right, k1, k2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Reading the size of the array
        int n = sc.nextInt();
        
        // Creating the BST
        Node root = null;
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        
        // Reading the range values k1 and k2
        int k1 = sc.nextInt();
        int k2 = sc.nextInt();
        
        // Printing the elements in the range [k1, k2] in increasing order
        printRange(root, k1, k2);
    }
}
