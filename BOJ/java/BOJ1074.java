import java.util.*;
import java.io.*;

class BOJ1074 {

    static int N,r,c;
    static int ans = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        cut(0,0,N, 0);
        System.out.println(ans);
        br.close();
    }

    static void cut(int row, int col, int pow, int val) {
        if (pow == 1) {
            if (r == row && c == col) 	       ans = val;
            else if (r == row && c == col+1)   ans = val+1;
            else if (r == row+1 && c == col)   ans = val+2;
            else if (r == row+1 && c == col+1) ans = val+3;
            return;
        }

        int max = (int) Math.pow(2, pow);
        int mid = max / 2;
        max = max * max;

        if (r < row + mid && c < col + mid) {
            cut(row, col, pow-1, val);
        } else if (r < row + mid && c >= col + mid) {
            cut(row, col+mid, pow-1, val+ (max/4));
        } else if (r >= row + mid && c < col + mid) {
            cut(row+mid, col, pow-1, val+ ((max/4)*2));
        } else if (r >= row + mid && c >= col + mid) {
            cut(row+mid, col+mid, pow-1, val+ ((max/4)*3));
        }
    }
}