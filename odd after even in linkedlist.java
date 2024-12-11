/*
Sample Input 0

1 4 5 2 -1
Sample Output 0

1 5 4 2
Sample Input 1

1 11 3 6 8 0 9 -1
Sample Output 1

1 11 3 9 6 8 0
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
    void odd( )
    {
        Node temp=head;
        while(temp!=null)
        {
            if(temp.data%2!=0)
            {    
            System.out.print(temp.data+" ");
            }
            temp=temp.next;
        }
    }
    void even()
    {
        Node temp=head;
        while(temp!=null)
        {
            if(temp.data%2==0)
            {    
            System.out.print(temp.data+" ");
            }
            temp=temp.next;
        }  
    }
}

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
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
        list.odd();
        list.even();
    }
}
