import java.util.*;
import java.io.*;
public class BOJ23288 {

    static final int[] dr = {0,1,0,-1};
    static final int[] dc = {1,0,-1,0};

    static class Dice {
        int[][] dice;
        int row, col, dir;

        public Dice() {
            dice = new int[][]{
                    {0,2,0},
                    {4,1,3},
                    {0,5,0},
                    {0,6,0}
            };
            row = 0;
            col = 0;
            dir = 0;
        }

        public int getBtm() {
            return dice[3][1];
        }

        public void roll() {

            int nr = row + dr[dir];
            int nc = col + dc[dir];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                if (dir == 0){
                    dir = 2;
                }
                else if (dir == 2) {
                    dir = 0;
                }
                else if (dir == 1) {
                    dir = 3;
                }
                else if (dir == 3) {
                    dir = 1;
                }
            }

            row += dr[dir];
            col += dc[dir];

            // 시계방향으로 적어둠
            if (dir == 0) { // 동
                rollEast();
            } else if (dir == 1) { // 남
                rollSouth();
            } else if (dir == 2) { // 서
                rollWest();
            } else if (dir == 3) { // 북
                rollNorth();
            }
            changeDir();
        }

        private void changeDir() {
            if (getBtm() > map[row][col]) { // 시계방향
                dir = (dir + 1) % 4;
            } else if (getBtm() < map[row][col]) {  // 반시계 방향
                dir -= 1;
                if (dir == -1)
                    dir = 3;
            }
        }

        private void rollEast() { // 동
            int temp = dice[3][1];
            dice[3][1] = dice[1][2];
            dice[1][2] = dice[1][1];
            dice[1][1] = dice[1][0];
            dice[1][0] = temp;
        }
        private void rollSouth() {   // 남
            int temp = dice[3][1];
            dice[3][1] = dice[2][1];
            dice[2][1] = dice[1][1];
            dice[1][1] = dice[0][1];
            dice[0][1] = temp;
        }
        private void rollWest() {    // 서
            int temp = dice[3][1];
            dice[3][1] = dice[1][0];
            dice[1][0] = dice[1][1];
            dice[1][1] = dice[1][2];
            dice[1][2] = temp;
        }

        private void rollNorth() { // 북
            int temp = dice[3][1];
            dice[3][1] = dice[0][1];
            dice[0][1] = dice[1][1];
            dice[1][1] = dice[2][1];
            dice[2][1] = temp;
        }
    }

    static int R,C,K;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }


        int score = 0;
        Dice dice = new Dice();
        for (int i = 0; i < K; i++) {
            dice.roll();
            score += bfsScore(dice.row, dice.col);
        }

        System.out.println(score);
    }

    static public int bfsScore(int row, int col) {
        int score = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];
        visited[row][col] = true;
        queue.add(new int[]{row, col});
        score = map[row][col];
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            for (int i = 0; i < 4; i++) {
                int nRow = curRow + dr[i];
                int nCol = curCol + dc[i];
                if (nRow < 0 || nCol < 0 || nRow >= R || nCol >= C) continue;
                if (map[curRow][curCol] != map[nRow][nCol]) continue;
                if (visited[nRow][nCol]) continue;
                visited[nRow][nCol] = true;
                queue.add(new int[]{nRow, nCol});
                score += map[nRow][nCol];
            }
        }
        return score;
    }
}