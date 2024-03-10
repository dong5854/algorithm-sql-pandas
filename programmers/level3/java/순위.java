import java.util.*;

class 순위 {
    
    static Integer[][] dp;
    
    public int solution(int n, int[][] results) {
        int answer = n;
        dp = new Integer[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        
        for (int[] result : results) {
            int winner = result[0] - 1;
            int loser = result[1] - 1;
            dp[winner][loser] = 1;
            dp[loser][winner] = -1;
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][k] == 1 && dp[k][j] == 1) {
                        dp[i][j] = 1;
                        dp[j][i] = -1;
                    }
                }
            }
        }
        
        for (Integer[] d : dp) {
            for (int i = 0; i < n; i++) 
                if (d[i] == Integer.MAX_VALUE) {
                    answer--;
                    break;
                }
        }
        
        return answer;
    }
}