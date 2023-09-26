import java.util.*;
import java.io.*;

public class CODETREE_구간에속한문자의개수 {

    static int n,m,k;
    static int[][] a;
    static int[][] b;
    static int[][] c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n+1][m+1];
        b = new int[n+1][m+1];
        c = new int[n+1][m+1];
        for (int row = 1; row <= n; row++) {
            String line = br.readLine();
            for (int col = 1; col <= m; col++) {
                char ch = line.charAt(col-1);
                if (ch == 'a') {
                    a[row][col] = 1 + a[row-1][col] + a[row][col-1] - a[row-1][col-1];
                } else {
                    a[row][col] = a[row-1][col] + a[row][col-1] - a[row-1][col-1];
                }

                if (ch == 'b') {
                    b[row][col] = 1 + b[row-1][col] + b[row][col-1] - b[row-1][col-1];
                } else {
                    b[row][col] = b[row-1][col] + b[row][col-1] - b[row-1][col-1];
                }

                if (ch == 'c') {
                    c[row][col] = 1 + c[row-1][col] + c[row][col-1] - c[row-1][col-1];
                } else {
                    c[row][col] = c[row-1][col] + c[row][col-1] - c[row-1][col-1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int aNum = a[r2][c2] - a[r1-1][c2] - a[r2][c1-1] + a[r1-1][c1-1];
            int bNum = b[r2][c2] - b[r1-1][c2] - b[r2][c1-1] + b[r1-1][c1-1];
            int cNum = c[r2][c2] - c[r1-1][c2] - c[r2][c1-1] + c[r1-1][c1-1];
            sb.append(aNum).append(" ").append(bNum).append(" ").append(cNum).append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}