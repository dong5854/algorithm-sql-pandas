import java.io.*;
import java.util.*;

public class 마라톤중간에택시타기2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // {x, y}
        int[][] checkPoints = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            checkPoints[i] = new int[]{x, y};
        }


        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < checkPoints.length - 1; i++) {
            int temp = 0;
            for (int j = 0; j < checkPoints.length - 1; j++) {
                if (j == i) continue;
                if ((j + 1) == i) {
                    temp += ManhattanDistance(checkPoints[j][0], checkPoints[j][1], checkPoints[j+2][0], checkPoints[j+2][1]);
                } else {
                    temp += ManhattanDistance(checkPoints[j][0], checkPoints[j][1], checkPoints[j+1][0], checkPoints[j+1][1]);
                }
            }
            ans = Math.min(ans, temp);
        }

        System.out.println(ans);

        br.close();
    }

    public static int ManhattanDistance(int x1,int y1,int x2,int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}