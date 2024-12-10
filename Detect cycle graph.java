/*
Input (stdin)
3
2 1
0 1
4 3
0 1 1 2 2 3
5 4
0 1 2 3 3 4 4 2

Output (stdout)
0
0
1
*/

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt(); // Number of test cases
        
        while (T-- > 0) {
            int N = scanner.nextInt(); // Number of vertices
            int M = scanner.nextInt(); // Number of edges
            
            // Initialize adjacency list
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                adjList.add(new ArrayList<>());
            }
            
            // Read edges
            for (int i = 0; i < M; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                adjList.get(u).add(v);
                adjList.get(v).add(u); // Because the graph is undirected
            }
            
            // Check for cycle in the graph
            boolean hasCycle = false;
            boolean[] visited = new boolean[N];
            
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    if (dfs(i, -1, visited, adjList)) {
                        hasCycle = true;
                        break;
                    }
                }
            }
            
            // Output result
            System.out.println(hasCycle ? 1 : 0);
        }
        
        scanner.close();
    }
    
    // DFS method to detect cycle
    private static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adjList) {
        visited[node] = true;
        
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adjList)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        
        return false;
    }
}
