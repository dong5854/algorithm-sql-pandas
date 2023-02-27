import java.io.*;
import java.util.*;

public class BOJ17471 {

    static int N;
    static int[] nodes;
    static int[][] graph;
    static boolean[] selected;
    static boolean[] v;
    static int ans;

    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nodes = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }

        graph = new int[N+1][];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cnt = Integer.parseInt(st.nextToken());
            graph[i] = new int[cnt];
            for (int c = 0; c < cnt; c++) {
                graph[i][c] = Integer.parseInt(st.nextToken());
            }
        }

        ans = Integer.MAX_VALUE;
        selected = new boolean[N+1];
        subs(1);
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static void subs(int cnt) {
        if (cnt == N+1) {
            int aCnt = 0; int bCnt = 0;
            // 1 번구역
            for (int i = 1; i <= N; i++) {
                if (selected[i]) {
                    v = new boolean[N+1];
                    aCnt = bfs(i, true);
                    break;
                }
            }
            // 2번구역
            for (int i = 1; i <= N; i++) {
                if (!selected[i]) {
                    v = new boolean[N+1];
                    bCnt = bfs(i, false);
                    break;
                }
            }
            if (aCnt == -1 || bCnt == -1) return; // 연결 안됨
            ans = Math.min(ans, Math.abs(aCnt - bCnt));	// 최솟값 구하기
            return;
        }

        selected[cnt] = true;
        subs(cnt+1);
        selected[cnt] = false;
        subs(cnt+1);
    }

    private static int bfs(int node, boolean selectedVal) {
        int cnt = 0;
        v[node] = true;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        cnt += nodes[node];

        while(!queue.isEmpty()) {
            int curNode = queue.poll();
            for (int i = 0; i < graph[curNode].length; i++) {
                int n = graph[curNode][i];
                if (v[n]) continue;	// 이미 방문
                if (selected[n] != selectedVal) continue; // 선택되지 못함
                v[n] = true;
                queue.add(n);
                cnt += nodes[n];
            }
        }

        for (int i = 1; i <= N; i++) { // 연결 확인
            if (v[i] != (selected[i] == selectedVal)) return -1;
        }
        return cnt;
    }
}