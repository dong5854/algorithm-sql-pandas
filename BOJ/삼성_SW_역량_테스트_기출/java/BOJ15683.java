import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//https://www.acmicpc.net/problem/15683
public class BOJ15683 {
    static int N;
    static int M;
    static int ans;
    static int[][] office;

    static List<int[]> cctv;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        cctv = new ArrayList<>();

        N = sc.nextInt();
        M = sc.nextInt();
        ans = Integer.MAX_VALUE;

        office = new int[N][M];
        int[][] detected = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                office[i][j] = sc.nextInt();
                if (office[i][j] != 0 && office[i][j] != 6) cctv.add(new int[]{i,j, office[i][j]});
            }
        }

        dfs(0, detected);

        System.out.println(ans);
    }

    public static void dfs(int cnt, int[][] detected) {
        if(cnt == cctv.size()) {
            getAns(detected);
            return;
        }

        int r = cctv.get(cnt)[0];
        int c = cctv.get(cnt)[1];
        int cctvNum = cctv.get(cnt)[2];

        detected[r][c] = 1;
        if (cctvNum == 1) {
            // 우
            right(r, c, detected);
            dfs(cnt+1, detected);
            resetRight(r, c, detected);
            // 하
            down(r, c, detected);
            dfs(cnt+1, detected);
            resetDown(r, c, detected);
            // 좌
            left(r, c, detected);
            dfs(cnt+1, detected);
            resetLeft(r, c, detected);
            // 상
            top(r, c, detected);
            dfs(cnt+1, detected);
            resetTop(r, c, detected);
        } else if (cctvNum == 2) {
            // 좌우
            left(r, c, detected);
            right(r, c, detected);
            dfs(cnt+1, detected);
            resetLeft(r, c, detected);
            resetRight(r, c, detected);
            // 상하
            top(r, c, detected);
            down(r, c, detected);
            dfs(cnt+1, detected);
            resetTop(r, c, detected);
            resetDown(r, c, detected);
        } else if (cctvNum == 3) {
            //상우
            top(r, c, detected);
            right(r, c, detected);
            dfs(cnt+1, detected);
            resetTop(r, c, detected);
            // 우하
            down(r, c, detected);
            dfs(cnt+1, detected);
            resetRight(r, c, detected);
            // 하좌
            left(r, c, detected);
            dfs(cnt+1, detected);
            resetDown(r, c, detected);
            // 좌상
            top(r, c, detected);
            dfs(cnt+1, detected);
            resetLeft(r, c, detected);
            resetTop(r, c, detected);
        } else if (cctvNum == 4) {
            // 하 빼고
            left(r, c, detected);
            top(r, c, detected);
            right(r, c, detected);
            dfs(cnt+1, detected);
            // 좌 빼고
            resetLeft(r, c, detected);
            down(r, c, detected);
            dfs(cnt+1, detected);
            // 상 빼고
            resetTop(r, c, detected);
            left(r, c, detected);
            dfs(cnt+1, detected);
            // 우 빼고
            resetRight(r, c, detected);
            top(r, c, detected);
            dfs(cnt+1, detected);
            // 다 빼기
            resetTop(r, c, detected);
            resetDown(r, c, detected);
            resetLeft(r, c, detected);
        } else if (cctvNum == 5) {
            top(r, c, detected);
            left(r, c, detected);
            right(r, c, detected);
            down(r, c, detected);
            dfs(cnt+1, detected);
            resetTop(r, c, detected);
            resetLeft(r, c, detected);
            resetRight(r, c, detected);
            resetDown(r, c, detected);
        }
        detected[r][c] = 0;
    }

    public static void getAns(int[][] detected) {
        int temp = 0;
        for(int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (detected[r][c] != 0) continue;
                if (office[r][c] == 0) temp++;
            }
        }
        ans = Math.min(ans, temp);
    }

    public static void right(int row, int col, int[][] detected) {
        for(int idx = row + 1; idx < N; idx++) {
            if (office[idx][col] == 6) break;
            if (office[idx][col] != 0) continue;
            detected[idx][col]++;
        }
    }
    public static void resetRight(int row, int col, int[][] detected) {
        for(int idx = row + 1; idx < N; idx++) {
            if (office[idx][col] == 6) break;
            if (office[idx][col] != 0) continue;
            detected[idx][col]--;
        }
    }

    public static void left(int row, int col, int[][] detected) {
        for(int idx = row - 1; idx >= 0; idx--) {
            if (office[idx][col] == 6) break;
            if (office[idx][col] != 0) continue;
            detected[idx][col]++;
        }
    }

    public static void resetLeft(int row, int col, int[][] detected) {
        for(int idx = row - 1; idx >= 0; idx--) {
            if (office[idx][col] == 6) break;
            if (office[idx][col] != 0) continue;
            detected[idx][col]--;
        }
    }

    public static void top(int row, int col, int[][] detected) {
        for(int idx = col - 1; idx >= 0; idx--) {
            if (office[row][idx] == 6) break;
            if (office[row][idx] != 0) continue;
            detected[row][idx]++;
        }
    }

    public static void resetTop(int row, int col, int[][] detected) {
        for(int idx = col - 1; idx >= 0; idx--) {
            if (office[row][idx] == 6) break;
            if (office[row][idx] != 0) continue;
            detected[row][idx]--;
        }
    }

    public static void down(int row, int col, int[][] detected) {
        for(int idx = col + 1; idx < M; idx++) {
            if (office[row][idx] == 6) break;
            if (office[row][idx] != 0) continue;
            detected[row][idx]++;
        }
    }

    public static void resetDown(int row, int col, int[][] detected) {
        for(int idx = col + 1; idx < M; idx++) {
            if (office[row][idx] == 6) break;
            if (office[row][idx] != 0) continue;
            detected[row][idx]--;
        }
    }

    public static int[][] copyMap(int[][] map) {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }
}
