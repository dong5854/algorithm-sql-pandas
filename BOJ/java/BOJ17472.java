import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17472 {

    static final int[] dr = {0,0,-1,1};
    static final int[] dc = {-1,1,0,0};

    static int N,M;
    static int[][] graph;
    static int isLandsAmt;
    static List<Edge> edges;

    static class Edge implements Comparable<Edge> {
        int from, to, weight;
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static class UnionFind {

        int[] roots;
        UnionFind() {
            roots = new int[isLandsAmt+1];
            for (int i = 0; i <= isLandsAmt; i++) {
                roots[i] = i;
            }
        }

        int find(int a) {
            if (roots[a] == a) {
                return a;
            }
            return roots[a] = find(roots[a]);
        }

        boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return false;
            roots[rootA] = rootB;   // a가 b 아래로
            return true;
        }
    }

    public static void main(String[] args) throws Exception{
        createGraph();
        giveNumberToGraph();
        getEdges();
        kruskal();
    }

    static void kruskal() {
        UnionFind unionFind = new UnionFind();
        int connectedAmt = 0; int size = 0;
        for(Edge e: edges) {
            if(unionFind.union(e.from, e.to)) {
                size += e.weight;
                connectedAmt++;
            }
            if (connectedAmt == isLandsAmt - 1) break; // 다리가 isLandAmt - 1 개만큼 생기면 완성
        }

        if (connectedAmt == isLandsAmt - 1) System.out.println(size);   // 최소 신장 트리 완성
        else System.out.println(-1);    // 최소 신장 트리 완성 못함
    }

    static void getEdges() {
        edges = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (graph[r][c] != 0) {
                    for (int d = 0; d < 4; d++) {
                        findEdgeDFS(r,c, 0, graph[r][c], d);
                    }
                }
            }
        }
        Collections.sort(edges);
    }

    static void findEdgeDFS(int row, int col, int cnt, int idx, int dir) {
        if (row < 0 || col < 0 || row >= N || col >= M) return; // 범위 밖
        if (cnt > 0 && graph[row][col] == idx) return; // 다음 땅이 육지일 경우
        if (graph[row][col] != 0 && graph[row][col] != idx) {   // 다른 섬과 연결
            if (cnt > 2) edges.add(new Edge(idx, graph[row][col], cnt-1)); // 다리 길이는 2 이상이어야 한다. cnt 는 1을 빼주어야 다리 길이
            return;
        }

        findEdgeDFS(row + dr[dir], col + dc[dir], cnt + 1, idx, dir);
    }

    static void createGraph() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                graph[r][c] = -Integer.parseInt(st.nextToken());
            }
        }
    }

    static void printGraph() {
        for (int[] g : graph) {
            System.out.println(Arrays.toString(g));
        }
    }

    static void giveNumberToGraph() {
        int idx = 1;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(graph[r][c] != 0) {
                    if (numBFS(r,c,idx)) {
                        isLandsAmt = idx;
                        idx++;
                    }
                }
            }
        }
    }

    static boolean numBFS(int row, int col, int idx) {
        if (graph[row][col] != -1) return false;
        graph[row][col] = idx;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {row, col});
        while (!queue.isEmpty()) {
            int[] rc = queue.poll();
            int curRow = rc[0]; int curCol = rc[1];
            for (int i = 0; i < 4; i++) {
                int nr = curRow + dr[i];
                int nc = curCol + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (graph[nr][nc] == idx || graph[nr][nc] == 0) continue;
                graph[nr][nc] = idx;
                queue.offer(new int[]{nr, nc});
            }
        }
        return true;
    }
}
