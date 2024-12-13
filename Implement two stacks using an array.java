/*
Input:
3
2 5 7

2
1 2
4
1
Output:
Stack 1 Elements:
7 5 2 
Stack 2 Elements:
2 1 
Stack underflow. pop from stack 1 failed
Stack 1 Elements:

Stack 2 Elements:
1 
*/
import java.util.*;
public class Main
{
  static class TwoStacks{
    int size;
    int top1, top2;
    int arr[];
    
    TwoStacks(int n){
      size= n;
      arr= new int[n];
      top1= -1;
      top2= size;      
    }
    
    void push1(int x)
    {
      if(top2 - top1 > 1)
      {
        top1++;
        arr[top1]= x;
      }
    }
    
    void push2(int x)
    {
      if(top2- top1 > 1){
        top2--;
        arr[top2]= x;
      }
    }
    
    int pop1()
    {
      if(top1 > -1){
        
        int x= arr[top1];
        top1--;
        return x;
      }
      else
        System.out.println("Stack underflow. pop from stack 1 failed");
      
      return -1;
    }
    
    int pop2()
    {
      if(top2 < size){
        int x = arr[top2];
        top2++;
        return x;
      }
      else
        System.out.println("Stack underflow. pop from stack 2 failed");
      
      return -1;
    }
    
    void print1()
    {
      int temp= top1;
      while(temp > -1){
        System.out.print(arr[temp]+" ");
        temp--;
      }
      System.out.println();
    }
    
    void print2()
    {
       int temp= top2;
      while(temp < size){
        System.out.print(arr[temp]+" ");
        temp++;
      }
      System.out.println();
    }
  }
  
  public static void main(String args[])
  {
    Scanner sc= new Scanner(System.in);
    
    TwoStacks st= new TwoStacks(1000);
    int size1= sc.nextInt();
    
    for(int i=0;i<size1;i++)
    {
      st.push1(sc.nextInt());
    }
    int size2= sc.nextInt();
    
    for(int i=0;i<size2;i++)
    {
      st.push2(sc.nextInt());
    }
    
    System.out.println("Stack 1 Elements: ");
    st.print1();
    System.out.println("Stack 2 Elements: ");
    st.print2();    
    
    
    int deleteFirst= sc.nextInt();
    
    while(deleteFirst-- >0)
      st.pop1();
    
    System.out.println("Stack 1 Elements: ");
    st.print1();
    
    int deleteSecond= sc.nextInt();
    
    while(deleteSecond-- >0)
      st.pop2();
    
    System.out.println("Stack 2 Elements: ");
    st.print2();
    
    
    sc.close();
  }
}
