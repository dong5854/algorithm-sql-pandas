import java.io.*;
import java.util.*;

public class 체크판위에서2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        if (map[0][0] == map[R-1][C-1]) {
            System.out.println(0);
            return;
        }

        char color = map[0][0];
        List<int[]> firsts = new ArrayList<>();
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (color != map[i][j]) firsts.add(new int[]{i,j});
            }
        }

        int ans = 0;
        for (int[] first : firsts) {
            int r = first[0];
            int c = first[1];
            color = map[first[0]][first[1]];
            for (int i = r + 1; i < R - 1; i++) {
                for (int j = c + 1; j < C - 1; j++) {
                    if (color != map[i][j]) {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);

        br.close();
    }
}