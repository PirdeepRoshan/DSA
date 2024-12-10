/*
Input:

6

P

T

P

T

T

P

3

Output:

Maximum thieves caught: 3


*/
import java.util.*;

public class Main{
  
  public static int police(char arr[], int n, int k)
  {
    int res=0;
    List<Integer> thi= new ArrayList<>();
    List<Integer> pol= new ArrayList<>();
    
    for(int i=0;i<n;i++)
    {
      if(arr[i]=='P')
      {
        pol.add(i);
      }
      else
        thi.add(i);
    }
    
    int l=0, r=0;
    while(l<thi.size() && r<pol.size())
    {
      if(Math.abs(thi.get(l)-pol.get(r))<=k)
      {
        res++;
        l++;
        r++;
      }
      else if(thi.get(l)<pol.get(r))
      {
        l++;
      }
      else{
        r++;
      }
    }
    
    return res;
  }
  public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    int n= sc.nextInt();
    
    char[] arr= new char[n];
    for(int i=0;i<n;i++)
    {
      arr[i]=sc.next().charAt(0);
    }
    
    int k=sc.nextInt();
    
    System.out.print("Maximum thieves caught: "+police(arr,n,k));
}
}
