/*
Sample Input 0

1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 0

1 2 4 5 3 6 7
*/
import java.io.*;
import java.util.*;
class TreeNode{
    int data;
    TreeNode left,right;
    TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class Main{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Queue<TreeNode> input = new LinkedList<>();    
        TreeNode root = new TreeNode(data);
        input.add(root);
        while(!input.isEmpty()){
            TreeNode node = input.poll();
            int leftval = sc.nextInt();
            
            if(leftval != -1){
                node.left = new TreeNode(leftval);
                input.add(node.left);
            }
            
            int rightval = sc.nextInt();
            if(rightval != -1){
                node.right = new TreeNode(rightval);
                input.add(node.right);
            }
        }
        PrintInorder(root);
    }
    
    public static void PrintInorder(TreeNode node){
        if(node == null){
            return;
        }
        
        
        System.out.print(node.data + " ");
        PrintInorder(node.left);
        PrintInorder(node.right);
    }
}
