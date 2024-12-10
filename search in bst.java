/*
Input (stdin)
6
8 5 10 2 6 7
2

Output (stdout)
true
*/

import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
public class Main {
    public static void main(String[] args) {
        Node head = null;
        int choice;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            Node new_node = new Node(x);
            head=insertNode(new_node,head);
        }
        int x2 = sc.nextInt();
        boolean found = search(x2, head);
        System.out.println(found);
    }

    static Node insertNode(Node pre, Node temp) {
        if (temp == null) {
            return pre;
        }
        if (temp.data >= pre.data) {
            temp.left = insertNode(pre, temp.left);
        } else {
            temp.right = insertNode(pre, temp.right);
        }
        return temp;
    }

    static boolean search(int x, Node temp) {
        if (temp == null) {
            return false;
        }
        if (x == temp.data) {
            return true;
        }
        if (x < temp.data) {
            return search(x, temp.left);
        }
        return search(x, temp.right);
    }
}
