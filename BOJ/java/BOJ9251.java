import java.io.*;
import java.util.*;

class BOJ9251 {

  static int[][] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String one = br.readLine();
    String two = br.readLine();
    dp = new int[one.length() + 1][two.length() + 1];

    int ans = 0;
    for (int i = 1; i <= one.length(); i++) {
      for (int j = 1; j <= two.length(); j++) {
        char oneChar = one.charAt(i - 1);
        if (two.charAt(j - 1) != oneChar) {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        } else {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        }
        ans = Math.max(ans, dp[i][j]);
      }
    }

    System.out.println(ans);
  }
}