import java.util.*;

class BOJ_17070 {

    // 백트래킹으로 모든 경로를 전부 탐색
    // 대각선 이동시에 비어 있어야 하는 곳이 3군데인 점 주의
    static int[][] house;
    static int N;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        house = new int[N][N];
        ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                house[i][j] = sc.nextInt();
            }
        }

        dfs(0, 1, 'H');

        System.out.println(ans);
    }

    public static void dfs(int row, int col, char status) {
        if (row == N -1 && col == N -1) {
            ans++;
            return;
        }

        if (status == 'H' || status == 'D') {   // 가로이동
            if (col + 1 < N && house[row][col + 1] == 0) dfs(row, col + 1, 'H');
        }

        if (status == 'V' || status == 'D') {   // 세로이동
            if (row + 1 < N && house[row + 1][col] == 0) dfs(row + 1, col, 'V');
        }

        if (row + 1 < N && col + 1 < N) {   // 대각선 이동은 전부 하므로 조건 없음
            if (house[row + 1][col] == 0 && house[row][col + 1] == 0 && house[row+1][col+1] == 0) { // 대각선 이동은 3곳이 비어 있어야한다.
                dfs(row+1, col + 1, 'D');
            }
        }
    }
}