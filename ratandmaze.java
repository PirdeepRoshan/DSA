/*
Input:

2

4 

2 1 0 0

3 0 0 1

0 1 0 1

0 0 0 1

4

2 1 0 0

2 0 0 1

0 1 0 1

0 0 0 1

Output:

1 0 0 0

1 0 0 1

0 0 0 1

0 0 0 1

-1
*/

import java.util.Scanner;

public class Main {
    // Display the solution matrix
    private static void display(int[][] sol, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check if a cell is within bounds and not blocked
    private static boolean isSafe(int[][] maze, int x, int y, int N) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] != 0);
    }

    // Recursive function to solve the maze
    private static boolean solveUtil(int[][] maze, int x, int y, int[][] sol, int N) {
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y, N)) {
            sol[x][y] = 1;

            int maxJump = maze[x][y];

            // Try moving right by i steps
            for (int i = 1; i <= maxJump; i++) {
                if (solveUtil(maze, x, y + i, sol, N)) {
                    return true;
                }
              // Try moving down by i steps
                if (solveUtil(maze, x + i, y, sol, N)) {
                    return true;
                }
            }

            sol[x][y] = 0; // Backtrack
        }

        return false;
    }

    // Solve the maze
    private static void solve(int[][] maze, int N) {
        int[][] sol = new int[N][N];

        if (!solveUtil(maze, 0, 0, sol, N)) {
            System.out.println("-1");
        } else {
            display(sol, N);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] maze = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    maze[i][j] = sc.nextInt();
                }
            }

            solve(maze, N);
        }

        sc.close();
    }
}
