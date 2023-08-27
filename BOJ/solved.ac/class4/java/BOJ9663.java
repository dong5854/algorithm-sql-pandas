import java.io.*;
public class BOJ9663 {
    static int cnt;
    public static void main(String[] args) throws Exception{
        int N = getN();
        int[] col = new int[N];
        cnt = 0;
        dfs(0, N, col);
        System.out.println(cnt);
    }

    // col 의 index == 행번호, col 의 value == 열번호
    private static void dfs(int row, int N, int[] col) {
        if (row == N) {
            cnt++;
            return;
        }
        for (int c = 0; c < N; c++) {
            col[row] = c;
            if (isPossible(row, col)) {
                dfs(row + 1, N, col);
            }
        }
    }

    private static boolean isPossible(int row, int[] col) {
        for (int i = 0; i < row; i++) {
            // 같은 열 or 대각선(행 번호 차이 == 열 번호 차이)
            if (col[row] == col[i] || row - i == Math.abs(col[row] - col[i])) {
                return false;
            }
        }
        return true;
    }

    private static int getN() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            return Integer.parseInt(br.readLine());
        } catch (Exception e) {
            throw e;
        }
    }
}
