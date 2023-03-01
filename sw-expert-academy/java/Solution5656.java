import java.util.*;
import java.io.*;
class Solution5656
{

    static final int[] dr = {0,0,-1,1};
    static final int[] dc = {1,-1,0,0};
    static int N,C,R;
    static int[] shoot;
    static int[][] graph;
    static int ans;
    static int max;
    static int temp;


    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            shoot = new int[N];
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            ans = Integer.MAX_VALUE;

            // 벽돌 입력 시작
            graph = new int[R][C];
            max = 0;
            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int c = 0; c < C; c++) {
                    graph[r][c] = Integer.parseInt(st.nextToken());
                    if (graph[r][c] != 0) max++;
                }
            }
            // 벽돌 입력 끝

            // 중복 순열
            perm(0, 0, graph);

            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static void perm(int cnt, int destroyed, int[][] map) {
        if (cnt == N) {
            return;
        }

        for (int i =0; i < C; i++) {
            // 벽돌 부수기 준비
            int[][] copied = copy(map);
            temp = 0;

            // 벽돌 부수기 시작
            int c = i;
            int r = 0;
            while (r < R && copied[r][c] == 0) {
                r++;
            }
            if (r == R) continue; // 벽돌이 없을 때
            dfs(copied, r, c);
            fallDown(copied);
            int dest = temp;
            ans = Math.min(ans, max - (destroyed + dest));
            perm(cnt+1, destroyed + dest, copied);
        }
    }

    private static int count(int[][] copied) {
        int cnt = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if(copied[r][c] != 0) cnt++;
            }
        }
        return cnt;
    }

    static int[][] copy(int[][] graph) {
        int[][] copied = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                copied[r][c] = graph[r][c];
            }
        }
        return copied;
    }


    private static void dfs(int[][] copied, int r, int c) { // 벽돌 깨트리기
        int target = copied[r][c];
        if (target == 1) {
            copied[r][c] = 0;
            temp++;
        } else if (target != 0) {
            copied[r][c] = 0;
            temp++;
            for (int i = 0; i < 4; i++) {
                int nr = r, nc = c;
                for (int toRemove = 0; toRemove < target - 1; toRemove++) {
                    nr = nr + dr[i];
                    nc = nc + dc[i];
                    if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                    if (copied[nr][nc] != 0) dfs(copied, nr, nc);
                }
            }
        }
    }

    private static void fallDown(int[][] map) { // 벽돌 제거 후 아래로 떨어뜨림
        Stack<Integer> stack = new Stack<>();

        for (int j = 0; j < C; j++) {
            for (int i = 0; i < R; i++) {
                if (map[i][j] != 0) {
                    stack.push(map[i][j]);
                    map[i][j] = 0;
                }
            }
            int index = R - 1;
            while (!stack.isEmpty()) {
                map[index--][j] = stack.pop();
            }

        }
    }
}