import java.util.*;
import java.io.*;

public class BOJ19236 {

    // 없는 값, 상, 좌상, 좌, 좌하, 하, 우하, 우, 우상 (반시계 방향 8방탐색)
    static final int[] dr = {100,-1,-1,0,1,1,1,0,-1};
    static final int[] dc = {100,0,-1,-1,-1,0,1,1,1};

    static class Fish implements Comparable<Fish>{

        int dir;
        int num;
        int row, col;

        public Fish(int num, int dir, int row, int col) {
            this.num = num;
            this.dir = dir;
            this.row = row;
            this.col = col;
        }

        public void move(Fish[][] graph, int sharkRow, int sharkCol) {
            int nr = this.row + dr[dir];
            int nc = this.col + dc[dir];

            while (nr < 0 || nc < 0 || nr >= 4 || nc >= 4 || (sharkRow == nr && sharkCol == nc)) {
                spin();
                nr = this.row + dr[dir];
                nc = this.col + dc[dir];
            }

            if (graph[nr][nc] != null) {	// 목적지에 물고기가 있으면 위치 바꿈
                Fish temp = graph[nr][nc];
                graph[this.row][this.col] = temp;
                temp.row = this.row;
                temp.col = this.col;
            } else {	// 물고기가 없으면 원래 위치에 null
                graph[this.row][this.col] = null;
            }
            graph[nr][nc] = this;
            this.row = nr;
            this.col = nc;
        }

        private void spin() {
            dir = (dir) % 8 + 1;
        }

        @Override
        public int compareTo(Fish o) {
            return Integer.compare(this.num, o.num);
        }
    }

    static Fish[][] graph;
    static int maxNum;
    static PriorityQueue<Fish> fishPQ;

    public static void main(String[] args) throws Exception {
        setup();
        // 시작 위치의 물고기는 무조건 먹고 시작
        Fish[][] copied = copyGraphAndMakePQ(graph, 0, 0);
        // 물고기 이동 로직
        while(!fishPQ.isEmpty()) {
            Fish polled = fishPQ.poll();
            polled.move(copied, 0, 0);
        }
        backTrack(0,0,graph[0][0].dir, graph[0][0].num, copied);
        System.out.println(maxNum);
    }

    private static void backTrack(int sharkRow, int sharkCol, int sharkDir, int numSum, Fish[][] graph) {
        if (maxNum < numSum) {
            maxNum = numSum;
        }
        int nRow = sharkRow;
        int nCol = sharkCol;
        while (true) {
            nRow += dr[sharkDir];
            nCol += dc[sharkDir];
            if (nRow < 0 || nCol < 0 || nRow >=4 || nCol >= 4) break; // 범위 밖으로 나가면 끝
            if (graph[nRow][nCol] != null) {
                // 먹힌 물고기 뺀 배열 리턴하고, pq 생성
                Fish[][] copied = copyGraphAndMakePQ(graph, nRow, nCol);
                // 물고기 이동 로직
                while(!fishPQ.isEmpty()) {
                    Fish polled = fishPQ.poll();
                    polled.move(copied, nRow, nCol);
                }
                backTrack(nRow, nCol, graph[nRow][nCol].dir, numSum + graph[nRow][nCol].num, copied);
            }
        }
    }

    static Fish[][] copyGraphAndMakePQ(Fish[][] graph, int exRow, int exCol) {
        Fish[][] copied = new Fish[4][4];
        fishPQ = new PriorityQueue<>();
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if (r == exRow && c == exCol) {
                    copied[r][c] = null;
                } else {
                    if (graph[r][c] != null) {
                        copied[r][c] = new Fish(graph[r][c].num, graph[r][c].dir, r, c);
                        fishPQ.add(copied[r][c]);
                    } else {
                        copied[r][c] = graph[r][c];
                    }
                }
            }
        }
        return copied;
    }

    static void setup() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new Fish[4][4];
        maxNum = 0;
        for (int r = 0; r < 4; r++) {
            StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < 4; c++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                graph[r][c] = new Fish(num, dir, r, c);
            }
        }
        br.close();
    }
}