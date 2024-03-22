import java.io.*;
import java.util.*;

public class CODETREE_별이있는숫자로만이동 {

    static int n,k;
    static int[][] board;
    static int[][] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n+1][n+1];
        s = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                s[i][j] = s[i][j-1] + board[i][j];
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int sumAll = 0;
                for (int r = i - k; r <= i + k; r++) {
                    int c = k - Math.abs(i - r);

                    if (1 <= r && r <= n) {
                        sumAll += s[r][Math.min(j + c, n)] - s[r][Math.max(j - c - 1, 0)];
                    }

                    ans = Math.max(ans, sumAll);
                }
            }
        }

        System.out.println(ans);

        br.close();
    }
}