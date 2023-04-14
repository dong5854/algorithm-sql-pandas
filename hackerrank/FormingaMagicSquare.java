import java.io.*;
import java.util.*;

class FormingaMagicSquare {

  /*
   * Complete the 'formingMagicSquare' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY s as parameter.
   */

  static int ans;
  static boolean[] v;

  public static int formingMagicSquare(List<List<Integer>> s) {
    v = new boolean[10];
    ans = Integer.MAX_VALUE;
    change(0, 0, 0, s);
    return ans;
  }

  static void change(int row, int col, int cost, List<List<Integer>> s) {
    if (cost > ans)
      return;
    if (col >= 3) {
      col = 0;
      row++;
    }
    if (row == 3) {
      int target = 0;
      for (int i = 0; i < 3; i++) {
        target += s.get(0).get(i);
      }

      // row, col
      for (int i = 0; i < 3; i++) {
        int rowSum = 0;
        int colSum = 0;
        for (int j = 0; j < 3; j++) {
          rowSum += s.get(i).get(j);
          colSum += s.get(j).get(i);
        }
        if (rowSum != target || colSum != target) {
          return;
        }
      }

      int diag = s.get(0).get(0) + s.get(1).get(1) + s.get(2).get(2);
      if (target != diag) {
        return;
      }

      diag = s.get(0).get(2) + s.get(1).get(1) + s.get(2).get(0);
      if (target != diag) {
        return;
      }

      if (cost < ans) {
        ans = cost;
      }
      return;
    }

    for (int i = 1; i <= 9; i++) {
      if (v[i])
        continue;
      v[i] = true;
      int original = s.get(row).get(col);
      s.get(row).set(col, i);
      change(row, col + 1, cost + Math.abs(original - i), s);
      v[i] = false;
      s.get(row).set(col, original);
    }
  }

}