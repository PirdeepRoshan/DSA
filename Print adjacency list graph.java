/*
Input:

2

5 7
0 1
0 4
1 2
1 3
1 4
2 3
3 4
3 3
0 1
1 2
2 0
Output:
0-> 1-> 4
1-> 0-> 2-> 3-> 4
2-> 1-> 3
3-> 1-> 2-> 4
4-> 0-> 1-> 3
0-> 1-> 2
1-> 0-> 2
2-> 1-> 0

Explanation:

Testcase 1: Given graph has 5 nodes and 7 edges. After creating adjacency list of given graph, we have created a list:
0-> 1-> 4
1-> 0-> 2-> 3-> 4
2-> 1-> 3
3-> 1-> 2-> 4
4-> 0-> 1-> 3
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();  // Number of test cases
        
        while (T-- > 0) {
            int V = scanner.nextInt();  // Number of vertices
            int E = scanner.nextInt();  // Number of edges
            
            // Initialize adjacency list
            List<List<Integer>> adjacencyList = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            
            // Read edges and populate adjacency list
            for (int i = 0; i < E; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                adjacencyList.get(u).add(v);
                adjacencyList.get(v).add(u);  // Because the graph is bidirectional
            }
            
            // Print adjacency list
            for (int i = 0; i < V; i++) {
                System.out.print(i + "->");
                List<Integer> list = adjacencyList.get(i);
                for (int j = 0; j < list.size(); j++) {
                    System.out.print(" " + list.get(j));
                    if (j < list.size() - 1) {
                        System.out.print("->");
                    }
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}
