/*
Input:
4
Output:
[2 4 1 3 ] [3 1 4 2 ]

Explanation:
These are the 2 possible solutions.

Input (stdin)
1
Output (stdout)
[1 ]
*/

import java.util.ArrayList;
import java.util.*;

class Main {

  static boolean isSafe(int row, int col, int[][] sol) {
    int n = sol.length;

    // Check this row on the left side
    for (int i = 0; i < row; i++) {
      if (sol[i][col] == 1) {
        return false;
      }
    }

    // Check upper-left diagonal
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (sol[i][j] == 1) {
        return false;
      }
    }

    // Check lower-left diagonal
    for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
      if (sol[i][j] == 1) {
        return false;
      }
    }

    return true;
  }

  static void nQueens(int row, int[][] sol, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp) {
    int n = sol.length;
    if (row == n) {
      res.add(new ArrayList<>(temp)); // Add a copy of temp to res
      return;
    }

    for (int col = 0; col < n; col++) {
      if (isSafe(row, col, sol)) {
        sol[row][col] = 1;  // Place the queen
        temp.add(col + 1);
          // Add column index (1-based) to temp
        nQueens(row + 1, sol, res, temp);
        sol[row][col] = 0;  // Backtrack
        temp.remove(temp.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int n = sc.nextInt();
    int[][] sol = new int[n][n];
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    nQueens(0, sol, res, new ArrayList<>());
    
    if (res.isEmpty()) {
      System.out.println("-1");
    } else {
      for (ArrayList<Integer> list : res) {
        System.out.print("[");
        for (int i : list) {
          System.out.print(i + " ");
        }
        System.out.print("] ");
      }
    }
  }
}
