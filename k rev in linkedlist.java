/*
Sample Input 0

1 2 3 4 5 6 7 8 9 10 -1
4
Sample Output 0

4 3 2 1 8 7 6 5 10 9
Sample Input 1

1 2 3 4 5 -1
0
Sample Output 1

1 2 3 4 5
*/

import java.io.*;
import java.util.*;

public class Solution{
    static class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
}

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Construct the linked list
        Node head=null, tail=null;
        int data=scanner.nextInt();
        while(data!=-1)
        {
            Node node=new Node(data);
            if(head==null)
            {
                head=node;
                tail=node;
            }else{
                tail.next=node;
                tail=node;
            }
            data=scanner.nextInt();
        }
        
        int k=scanner.nextInt();
        
        head =reverseInGrp(head,k);
        
        while(head!=null)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
        
    }

    static Node reverseInGrp(Node head,int k)
    {
    if(k==0 || k==1)
    {
        return head;
    }
    Node current=head, prev=null, next=null;
    int count=0;
    while(current!=null && count<k)
    {
        next=current.next;
        current.next=prev;
        prev=current;
        current=next;
        count++;
    } 
    if(next!=null){
        head.next=reverseInGrp(next, k);
    }return prev;
    }
}

   
