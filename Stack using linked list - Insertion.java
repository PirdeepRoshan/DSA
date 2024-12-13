/*
Input (stdin)
1
2
3
4
-1

Output (stdout)
4 3 2 1
*/

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int a) {
        data = a;
        next = null;
    }
}

class Stack {
    Node top=null;
  
    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public void display() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner scanner = new Scanner(System.in);
      
        int input = scanner.nextInt();
        while (input != -1) {
            stack.push(input);
            input = scanner.nextInt();
        }
        stack.display();
    }
}
