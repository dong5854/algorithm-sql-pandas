import java.io.*;
import java.util.*;

public class CODETREE술래잡기 {

    // 상, 우, 하, 좌
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static Runner[] runnerList;
    static int N;
    static int M;
    static int H;
    static int K;

    static class Sullae {
        boolean turned;
        int row;
        int col;
        int dir;
        int score;

        public Sullae(int row, int col, int dir) {
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.score = 0;
            this.turned = false;
        }

        // 술래의 이동 후 턴까지
        public void moveAndTurn() {
            this.row += dr[dir];
            this.col += dc[dir];
            // 정방향 중에서 방향 전환 포인트에서는 방향 전환, 상 우 하 좌
            if (turnPoints[this.row][this.col] && !turned) {
                this.dir = (this.dir + 1) % 4;
            }

            // 역방향 중에서 방향 전환 포인트에서는 방향 전환, 하, 우, 상, 좌
            if (turnPoints[this.row][this.col] && turned) {
                this.dir = this.dir - 1;
                if (this.dir == -1) {
                    this.dir = 3;
                }
            }
            // 좌상단에서의 방향 전환
            if (this.row == 0 && this.col == 0) {
                turned = !turned;
                this.dir = 2;
            }
            if (this.row == N/2 && this.col == N/2) {
                turned = !turned;
                this.dir = 0;
            }
        }

        public void catchRunner(int turn) {
            for (int i = 0; i < 3; i++) {
                int toLookR = this.row + i * dr[dir];
                int toLookC = this.col + i * dc[dir];
                if (toLookR < 0 || toLookC < 0 || toLookR >= N || toLookC >= N) continue;
                if (trees[toLookR][toLookC]) continue;
                for (Runner r : runnerList) {
                    if (r.caught) continue;
                    if (r.row == toLookR && r.col == toLookC) {
                        r.caught = true;
                        score += turn;
                    }
                }
            }
        }
    }

    static class Runner {
        boolean caught;
        int row;
        int col;
        int dir;
        // 이동 방법, 좌우인 경우 1, 상하인 경우 2
        int strategy;

        public Runner(int row, int col, int strategy) {
            this.row = row;
            this.col = col;
            this.strategy = strategy;
            this.caught = false;
            if (strategy == 1) {    // 이동방법이 1인 경우 오른쪽을 보고 시작
                dir = 1;
            } else if (strategy == 2) {// 이동방법이 2인 경우 아래를 보고 시작
                dir = 2;
            }
        }

        public void move() {
            int distance = distanceWithSullae();
            // 현재 술래와의 거리가 3 이하인 도망자만 움직인다.
            if (distance > 3) return;
            int nRow = this.row + dr[this.dir];
            int nCol = this.col + dc[this.dir];
            // 격자 밖이면 방향 전환
            if (nRow < 0 || nCol < 0 || nRow >= N || nCol >= N) {
                this.dir = (this.dir + 2) % 4;
                nRow = this.row + dr[this.dir];
                nCol = this.col + dc[this.dir];
            }
            // 움직이려는 칸에 술레가 있는 경우 움직이지 않습니다.
            if (nRow == sullae.row && nCol == sullae.col) {
                return;
            }
            this.row = nRow;
            this.col = nCol;
        }

        public int distanceWithSullae() {
            return Math.abs(this.row - sullae.row) + Math.abs(this.col - sullae.col);
        }

        @Override
        public String toString() {
            return caught + "";
        }
    }

    static boolean[][] turnPoints;
    static boolean[][] trees;
    static Sullae sullae;

    public static void main(String[] args) throws Exception {
        setUp();

        // 턴은 K 번 진행
        for (int k = 1; k <= K; k++) {
            // 이동 후
            for (Runner r : runnerList) {
                if (r.caught) continue;
                r.move();
            }

            // 술래의 이동 후 필요하면 방향 전환
            sullae.moveAndTurn();
            sullae.catchRunner(k);
        }

        System.out.println(sullae.score);
    }
    static void setUp() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        turnPoints = new boolean[N][N];
        trees = new boolean[N][N];

        // 술래 정의
        sullae = new Sullae(N/2, N/2,0);
        // turn point 찍기
        setTurnPoint();

        runnerList = new Runner[M];
        // 도망자의 위치가 차례로 주어진다.
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            Runner runner = new Runner(x,y,d);
            runnerList[m] = runner;
        }

        // 나무의 위치가 차례로 주어진다.
        for (int h = 0; h < H; h++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            trees[x-1][y-1] = true;
        }

        br.close();
    }

    static void setTurnPoint() {
        int row = N / 2; int col = N / 2;
        int dir = 0; int move = 1;
        while (true) {
            row = row + move * dr[dir];
            col = col + move * dc[dir];
            if (row == -1 && col == 0) {
                break;
            }
            turnPoints[row][col] = true;
            if (dir == 1 || dir == 3) {
                move += 1;
            }
            dir = (dir + 1) % 4;
        }
    }
}
