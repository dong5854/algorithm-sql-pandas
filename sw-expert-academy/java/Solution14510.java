import java.util.*;
import java.io.*;

class Solution14510
{

    static int N;
    static int[] trees;
    static int tallest;


    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            trees = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(trees);
            tallest = trees[N-1];

            int oddDays = 0;    // 필요한 홀수 날짜들
            int evenDays = 0;   // 필요한 짝수 날짜들
            for (int i = 0; i < N-1; i++) {
                oddDays += (tallest - trees[i]) % 2; // 무조건 홀수에 한번 물을 줘야한다.
                evenDays += (tallest - trees[i]) / 2; // 짝수날짜 개수
            }
            int dayDiff =  evenDays - oddDays;
            while (dayDiff > 1) {   // 짝수날짜를 쪼개서 홀수날짜에 때울 수 있다면, 쪼개서 때운다.
                evenDays -= 1;
                oddDays += 2;
                dayDiff =  evenDays - oddDays;
            }
            if (dayDiff < -1) {
                while (oddDays - evenDays != 1) {    // 홀수 날이 더 많으면 스킵하는 짝수 날도 채워줘야한다.
                    evenDays++;
                }
            } else if (dayDiff == 1) {
                oddDays++;   // 짝수 날이 하루 더 많으면 스킵하는 홀수날을 하나 채워줘야한다.
            }
            sb.append("#").append(test_case).append(" ").append(evenDays + oddDays).append("\n");
        }
        System.out.println(sb);
    }


    static boolean days(int[] trees, int idx, int day) {
        if (trees[idx] == tallest) return false;
        int toGrow  = tallest - trees[idx];
        if (day % 2 == 1) {
            if (toGrow == 1 || toGrow > 2) trees[idx] += 1;
            else return false;
        } else {
            if (toGrow == 2 || toGrow > 2) trees[idx] += 2;
            else return false;
       }
        return true;
    }
}