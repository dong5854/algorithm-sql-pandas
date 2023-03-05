import java.util.*;
import java.io.*;

class Solution2115
{

    static int ans;
    static int N,M,C;
    static int[][] graph;
    static Integer[][] honey;   // 채집한 벌통

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            honey = new Integer[2][M];  // 아저씨 2명이 벌통 M 개씩 채취, M이 5 이하로 작으니까 나중에 정렬해도 될듯?
            graph = new int[N][N];
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int c = 0; c < N; c++) {
                    graph[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            comb(0,0,0);
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static void comb(int cnt, int rowStart, int colStart) {
        if (cnt == 2) { // 채집가가 두명
            getHoney();
            return;
        }

        for (int r = rowStart; r < N; r++) {
            for (int c = colStart; c <= N-M; c++) {
                int idx = 0;
                for (int i = c; i < c + M; i++) {
                    honey[cnt][idx++] = graph[r][i];
                }
                comb(cnt + 1, r, c + M);
            }
            colStart = 0;
        }
    }

    static void getHoney() {
        int totalProfit = 0;
        for (int i = 0; i < 2; i++) {
            Arrays.sort(honey[i], Collections.reverseOrder());  // 많이 들은 칸을 먼저 채취해야 하므로 내림차순
            int profit = 0;
            for (int hIdx = 0; hIdx < M; hIdx++) {
                int totalHoney = 0; // 채취한 꿀의 양
                int tempProfit = 0; // 수익
                for (int h = hIdx; h < M; h++) {
                    if (totalHoney + honey[i][h] > C) continue;
                    totalHoney += honey[i][h];
                    tempProfit += honey[i][h] * honey[i][h];
                }
                if (profit < tempProfit) {
                    profit = tempProfit;
                }
            }
            totalProfit += profit;
        }
        if (ans < totalProfit) {
            ans = totalProfit;
        }
    }
}