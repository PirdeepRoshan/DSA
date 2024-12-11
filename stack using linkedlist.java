/*
Sample Input 0
6
1 13
1 47
4
5
2
3
Sample Output 0
2
false
47
13
Sample Input 1
4
5
2
1 10
5
Sample Output 1
true
-1
false
*/
import java.io.*;
import java.util.*;

class StackNode {
    int data;
    StackNode next;
    StackNode(int val) {
        data = val;
        next = null;
    }
}
class Stack {
    StackNode top = null;
    int size = 0;

    public void push(int data) {
        StackNode node = new StackNode(data);
        node.next = top; // Set the new node's next to the current top
        top = node; // Update top to the new node
        size++; // 2
    }
    public int pop() {
        if (isEmpty()) {
            // System.out.print("Stack underflow");
            return -1;
        } else {
            int res = top.data;// 47
            top = top.next;
            size--;// 1
            return res;
        }
    }
    public int peek() {
        if (isEmpty()) {
            // System.out.print("Stack underflow");
            return -1;
        }
        return top.data;
    }
    public int getSize() { // Renamed to avoid conflict with the variable size
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        int q = sc.nextInt();// 6
        while (q-- > 0) {
            int type = sc.nextInt();// 1 1 4
            switch (type) {
                case 1:
                    int data = sc.nextInt(); // 13 47
                    stack.push(data);
                    break;
                case 2:
                    System.out.println(stack.pop());
                    break;
                case 3:
                    System.out.println(stack.peek());
                    break;
                case 4:
                    System.out.println(stack.getSize()); // Updated method call
                    break;
                case 5:
                    System.out.println(stack.isEmpty());
                    break;
            }
        }
        sc.close();
    }
}
