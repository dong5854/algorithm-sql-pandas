import java.util.*;
import java.io.*;

class Solution1767
{
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    static int ans;
    static int[][] graph;
    static int N;
    static List<int[]> cores;
    static boolean[] coreIncluded;


    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            // 전선길이, 연결된 코어 수
            ans = Integer.MAX_VALUE;
            // 가장자리가 아닌 코어들
            cores = new ArrayList<>();

            N = Integer.parseInt(br.readLine());

            graph = new int[N][N];
            for (int r = 0; r < N; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int c = 0; c< N; c++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp == 1) {
                        if (r != 0 && c != 0 && r != N-1 && c != N -1) cores.add(new int[]{r,c});
                    };
                    graph[r][c] = temp;
                }
            }
            coreIncluded = new boolean[cores.size()];

            for (int i = cores.size(); i >= 0; i--) {
                combi(0, 0, i);
                if(ans < Integer.MAX_VALUE) break;
            }
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void combi(int cnt, int idx, int R) {
        if (cnt == R) {
            connectDFS(0,0);
            return;
        }
        for (int i = idx; i < cores.size(); i++) {
            coreIncluded[i] = true;
            combi(cnt+1, i + 1, R);
            coreIncluded[i] = false;
        }
    }

    static void connectDFS(int idx, int length) {
        if (idx == cores.size()) {
            ans = Math.min(ans, length);
            return;
        }

        if (!coreIncluded[idx]) {
            connectDFS(idx+1, length);
        }

        for (int i = 0; i < 4; i++) {
            int r = cores.get(idx)[0];
            int c = cores.get(idx)[1];
            int tmp = 0;
            boolean success = false;
            while (true) {
                r += dr[i]; c += dc[i];
                if (r < 0 || c < 0 || r >= N || c >= N) {
                    success = true;
                    break;
                }
                if (graph[r][c] != 0) break;
                graph[r][c] = 2;
                tmp++;
            }
            if(success) connectDFS(idx + 1, length + tmp);
            while (true) {
                r -= dr[i]; c -= dc[i];
                if(r == cores.get(idx)[0] && c == cores.get(idx)[1]) break;
                graph[r][c] = 0;
            }
        }
    }
}