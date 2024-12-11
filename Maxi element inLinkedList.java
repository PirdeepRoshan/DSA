/*
Sample Input 0

1 2 3 4 5 -1
Sample Output 0

5
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
    
    void insert_end(int elem)
    {
        Node newnode= new Node(elem);
        if(head==null)
        {
            head=newnode;
        }
        else
        {
            Node last=head;
            while(last.next!=null)
            {
              last=last.next;  
            }
            last.next=newnode;
        }
    }
    void max( )
    {
        Node temp=head;
        int max=0;
        while(temp!=null)// 4>3
        {
            if(temp.data>max)
            {
                max=temp.data;
            }
            temp=temp.next;
        }
        System.out.println(max);
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
                list.insert_end(elem);
            }
        }
        list.max();
    }
}
