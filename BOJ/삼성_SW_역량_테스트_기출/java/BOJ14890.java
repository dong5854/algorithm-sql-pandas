import java.util.*;
//https://www.acmicpc.net/problem/14890
public class BOJ14890 {
    static int N, L;
    static int[][] map;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();

        map = new int[N][N];
        ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            int[] row = new int[N];
            boolean[] rowMade = new boolean[N];
            boolean rFlag = true;
            int[] col = new int[N];
            boolean[] colMade = new boolean[N];
            boolean cFlag = true;

            for (int j = 0; j < N; j++) {   // 일단 줄세우기
                row[j] = map[i][j];
                col[j] = map[j][i];
            }

            for (int j = 1; j < N; j++) {   // 경사로 체크
                if (!rFlag && !cFlag) continue;
                // row
                if (row[j-1] < row[j]) {    // row 높아짐
                    for (int l = 1; l <= L; l++) {
                        if (j - l < 0) {
                            rFlag = false;
                            continue;
                        }
                        else if (row[j] - row[j-l] != 1) rFlag = false;
                        if (rowMade[j-l]) rFlag = false;    // 세움 체크
                        else rowMade[j-l] = true;
                    }
                } else if (row[j-1] > row[j]) { // 낮아짐
                    for(int l = 0; l < L; l++) {
                        if (j + l >= N) {
                            rFlag = false;
                            continue;
                        }
                        else if (row[j-1] - row[j+l] != 1) rFlag = false;
                        if (rowMade[j+l]) rFlag = false; // 세움 체크
                        else rowMade[j+l] = true;
                    }
                }

                // col
                if (col[j-1] < col[j]) {    // row 높아짐
                    for (int l = 1; l <= L; l++) {
                        if (j - l < 0) {
                            cFlag = false;
                            continue;
                        }
                        else if (col[j] - col[j-l] != 1) cFlag = false;
                        if (colMade[j-l]) cFlag = false;    // 세움 체크
                        else colMade[j-l] = true;
                    }
                } else if (col[j-1] > col[j]) { // 낮아짐
                    for(int l = 0; l < L; l++) {
                        if (j + l >= N) {
                            cFlag = false;
                            continue;
                        }
                        else if (col[j-1] - col[j+l] != 1) cFlag = false;
                        if (colMade[j+l]) cFlag = false; // 세움 체크
                        else colMade[j+l] = true;
                    }
                }
            } // 경사로 체크 끝
            if (rFlag) ans++;
            if (cFlag) ans++;
        }

        System.out.println(ans);
    }
}
