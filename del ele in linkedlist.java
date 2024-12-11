/*
Sample Input 0

3 4 5 2 6 1 9 -1
3
Sample Output 0

3 4 5 6 1 9
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
    void crelinked_list(int elem)
    {
        Node newnode=new Node(elem);
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
    void deletei(int pos)
    {
        int count = 0;
        if (head == null) {
            return;
        } else if (pos == 0) {
            head = head.next;
        } else {
            Node last = head;// 2< 2
            while (count < pos - 1 && last.next != null) {
                last = last.next; // 3 4 5 7 8
                count++;
            }
            if (last.next != null) {
                last.next = last.next.next;
            }
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
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        linked_list list=new linked_list();
        int elem=0;
        while(elem!=-1)
        {
            elem=sc.nextInt();
            if(elem==-1)
            {
                break;
            }
            else
            {
             list.crelinked_list(elem);   
            }
        }
        int pos=sc.nextInt();
        list.deletei(pos);
        list.display();
    }
}
