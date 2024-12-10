/*
Input (stdin)
4
0 1
0 2
1 2
2 0
2 3
3 3
-1 -1

Output (stdout)
BFS : 0 1 2 3
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();

        if (vertices == 0) {
            System.out.println("Graph doesn't exist");
            return;
        }

        // Create adjacency matrix
        int[][] adjMatrix = new int[vertices][vertices];

        while (true) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (u == -1 && v == -1) {
                break;
            }
            adjMatrix[u][v] = 1; // Mark edge from u to v
        }

        System.out.print("BFS : ");
        bfs(0, adjMatrix, vertices);
    }

    public static void bfs(int start, int[][] adjMatrix, int vertices) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
