import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

class Solution3316
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String days = br.readLine();
            int[][] dp = new int[16][days.length()];
            firstDay(days, dp);
            for (int day = 1; day < days.length(); day++) {
                afterSecondDay(day, days, dp);
            }
            int ans = getSum(days, dp);
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static void firstDay(String days, int[][] dp) {
        int admin = 1 << (days.charAt(0) - 'A');
        for (int i = 1; i < 16; i++) {
            if ((i & admin) != 0 && (i & 1) != 0) {
                dp[i][0] = 1;
            }
        }
    }

    static void afterSecondDay(int day, String days, int[][] dp) {
        int admin = 1 << (days.charAt(day)) - 'A';
        for (int i = 1; i < 16; i++) { // 모든 전날에 대해 체크
            if (dp[i][day-1] == 0) continue; // 전날에 누군가는 있어야 한다. 없다면 스킵
            for (int j = 1; j < 16; j++) {
                if((j & admin) != 0 && (i & j) != 0) { // 오늘 담당자가 있고 && 전날과 오늘 중 적어도 한명은 공통되는 참가자가 필요하다.
                    dp[j][day] += dp[i][day-1];
                    dp[j][day] %= 1000000007;
                }
            }
        }
    }

    static int getSum(String days, int[][] dp) {
        int sum = 0;
        for (int i = 1; i < 16; i++) {
            sum += dp[i][days.length()-1];
            sum %= 1000000007;
        }
        return sum;
    }
}