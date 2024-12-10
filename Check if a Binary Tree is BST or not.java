/*
Input (stdin)
5
4 2 5 1 3

Output (stdout)
True
*/

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Main {
    
    // Function to insert nodes in level order
    public static Node buildTree(int[] arr, int n) {
        if (n == 0) return null;
        
        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        int i = 1;
        while (i < n) {
            Node current = queue.poll();
            
            // Insert the left child
            if (i < n) {
                current.left = new Node(arr[i++]);
                queue.add(current.left);
            }
            
            // Insert the right child
            if (i < n) {
                current.right = new Node(arr[i++]);
                queue.add(current.right);
            }
        }
        return root;
    }
    
    // Function to check if the tree is a BST
    public static boolean isBST(Node node, Integer min, Integer max) {
        if (node == null) return true;
        
        if ((min != null && node.data <= min) || (max != null && node.data >= max)) return false;
        
        return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        Node root = buildTree(arr, n);
        
        // Check if the constructed tree is a BST
        if (isBST(root, null, null)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        
        scanner.close();
    }
}
