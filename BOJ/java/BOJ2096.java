import  java.io.*;
import  java.util.*;

public class BOJ2096 {

    static final int INF = Integer.MAX_VALUE / 2;
    static int N;
    static int[][] minCache;
    static int[][] maxCache;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        minCache = new int[2][3];
        maxCache = new int[2][3];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 3; i++) {
            int val = Integer.parseInt(st.nextToken());
            minCache[0][i] = val;
            maxCache[0][i] = val;
        }

        int[] temp = new int[3];
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            temp[0] = Integer.parseInt(st.nextToken());
            temp[1] = Integer.parseInt(st.nextToken());
            temp[2] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 3; j++) {
                int minVal = INF; int maxVal = 0;

                minVal = Math.min(minVal, minCache[(i-1)%2][j]);
                maxVal = Math.max(maxVal, maxCache[(i-1)%2][j]);

                if (j - 1 >= 0) {
                    minVal = Math.min(minVal, minCache[(i-1)%2][j-1]);
                    maxVal = Math.max(maxVal, maxCache[(i-1)%2][j-1]);
                }

                if (j + 1 < 3) {
                    minVal = Math.min(minVal, minCache[(i-1)%2][j+1]);
                    maxVal = Math.max(maxVal, maxCache[(i-1)%2][j+1]);
                }

                minCache[i%2][j] = minVal + temp[j];
                maxCache[i%2][j] = maxVal + temp[j];
            }
        }

        int minVal = INF; int maxVal = 0;
        if (N % 2 == 0) {
            for (int i = 0; i < 3; i++) {
                minVal = Math.min(minVal, minCache[1][i]);
                maxVal = Math.max(maxVal, maxCache[1][i]);
            }
        } else {
            for (int i = 0; i < 3; i++) {
                minVal = Math.min(minVal, minCache[0][i]);
                maxVal = Math.max(maxVal, maxCache[0][i]);
            }
        }

        System.out.println(maxVal + " " +minVal);
    }
}
