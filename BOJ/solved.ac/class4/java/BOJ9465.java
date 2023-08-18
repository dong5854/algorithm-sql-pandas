import java.io.*;
import java.util.*;
public class BOJ9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] ticket = new int[2][n+1];
            for (int r = 0; r < 2; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int c = 1; c <= n; c++) {
                    ticket[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 2; i <= n; i++) {
                ticket[0][i] += Math.max(ticket[1][i-1], ticket[1][i-2]);
                ticket[1][i] += Math.max(ticket[0][i-1], ticket[0][i-2]);
            }
            System.out.println(Math.max(ticket[0][n], ticket[1][n]));
        }
    }
}
