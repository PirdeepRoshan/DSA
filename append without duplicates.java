/*
Sample Input 0

1 2 3 1 2 -1
Sample Output 0

1 2 3
Sample Input 1

2 3 4 -1
Sample Output 1

2 3 4
*/
import java.io.*;
import java.util.*;
class linked_list
{
    Node head;
    class Node
    {
        int data;
        Node next;
        Node(int elem)
        {
            data=elem;
            next=null;
        }
    }   
    void createlist(int elem)
    {
        Node newnode= new Node(elem);
        if(head==null)
        {
            head=newnode;
        }
        else
        {
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;  
            }
            temp.next=newnode;
        }
    }
    
    void removeDuplicates()
    {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    void display()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner a=new Scanner(System.in);
        linked_list list=new linked_list();
        int elem=0;
        while(elem!=-1)                   
        { 
            elem=a.nextInt();
            if(elem==-1)
            {
                break;
            }
            else
            {
                list.createlist(elem);
            }
        }
        list.removeDuplicates(); // Added this line to remove duplicates
        list.display();
    }
}
