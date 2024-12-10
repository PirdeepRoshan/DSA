/*
Input:
6

3

1

4

2

-1

Output:

Sum of all nodes are 16
*/

import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Main {

    static TreeNode root = null; // Declare root as a static global variable

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reading input and constructing the BST
        while (true) {
            int val = sc.nextInt();
            if (val == -1) break; // Stop when -1 is encountered
            insert(val); // Insert values into the BST
        }

        // Calculating and printing the sum of all nodes
        int sum = sumOfNodes(root);
        System.out.println("Sum of all nodes are " + sum);

        sc.close();
    }

    // Method to insert a new value into the binary search tree
    static void insert(int val) {
        if (root == null) {
            root = new TreeNode(val); // Create the root node
            return;
        }

        TreeNode current = root;
        while (true) {
            if (val < current.val) {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                } else {
                    current = current.left;
                }
            } else if (val > current.val) {
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    break;
                } else {
                    current = current.right;
                }
            }
        }
    }

    // Method to calculate the sum of all nodes in the tree
    static int sumOfNodes(TreeNode root) {
        if (root == null) return 0;
        return root.val + sumOfNodes(root.left) + sumOfNodes(root.right);
    }
}
