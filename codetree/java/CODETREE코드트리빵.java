import java.io.*;
import java.util.*;

public class CODETREE코드트리빵 {

	// 상, 좌, 우, 하
	static final int[] dr = {-1 ,0 , 0, 1};
	static final int[] dc = {0 ,-1 , 1, 0};
	
	static int[][] graph;
	static int[][] avoidConvTime;
	static int[][] conv;
	static int[][] base;
	static int N, M;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		ans = 0;
		setInfo();
		// 베이스캠프 찾기
		findBase();
		for (int i = 0; i < M; i++) {
			bfs(base[i][0], base[i][1], i+1);
		}
		System.out.println(ans);
	}

	private static void bfs(int row, int col, int startTime) {
		boolean[][] v= new boolean[N][N];
		v[row][col] = true;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {row, col, startTime});
		while (!q.isEmpty()) {
			int[] polled = q.poll();
			int cRow = polled[0];
			int cCol = polled[1];
			int cTime = polled[2];
			for (int d = 0; d < 4; d++) {
				int nRow = cRow + dr[d];
				int nCol = cCol + dc[d];
				// 범위 밖
				if (nRow < 0 || nCol < 0 || nRow >= N || nCol >= N) continue;
				// 목적지 도착한 경우
				if (graph[nRow][nCol]- startTime == 1) {
					ans = Math.max(ans, cTime + 1);
					return;
				}
				// 이미 닫힘
				if (avoidConvTime[nRow][nCol] != 0 && avoidConvTime[nRow][nCol] <= cTime + 1) continue;
				if (v[nRow][nCol]) continue;
				v[nRow][nCol] = true;
				q.add(new int[] {nRow, nCol, cTime + 1});
			}
		}
	}

	private static void findBase() {
		for (int m = 0; m < M; m++) {
			int[] c = conv[m];
			// 가장 우선순위에 적합한 베이스 캠프를 찾기 위한 pq
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
				// 가까운거 먼저
				int comp = Integer.compare(o1[2], o2[2]);
				// 같다면 행이 작은 거 먼저
				if (comp == 0) comp = Integer.compare(o1[0], o2[0]);
				// 마지막으로 열이 작은거
				if (comp == 0) comp = Integer.compare(o1[1], o1[1]);
				return comp;
			});
			Queue<int[]> q = new ArrayDeque<int[]>();
			boolean[][] v = new boolean[N][N];
			int row = c[0];
			int col = c[1];
			v[row][col] = true;
			// row, col, cnt
			q.add(new int[] {row, col, 0});
			while (!q.isEmpty()) {
				int[] polled = q.poll();
				int cRow = polled[0];
				int cCol = polled[1];
				int cCnt = polled[2];
				for (int d = 0; d < 4; d++) {
					int nRow = cRow + dr[d];
					int nCol = cCol + dc[d];
					if (nRow < 0 || nCol < 0 || nRow >= N || nCol >= N) continue;
					if (v[nRow][nCol]) continue;
					v[nRow][nCol] = true;
					// 베이스 캠프인 경우
					if (graph[nRow][nCol] == 1) {
						pq.add(new int[] {nRow, nCol, cCnt + 1});
						continue;
					}
					q.add(new int[] {nRow, nCol, cCnt + 1});
				}
			}
			int[] chosenBase = pq.poll();
			base[m] = new int[] {chosenBase[0], chosenBase[1]};
			avoidConvTime[chosenBase[0]][chosenBase[1]] = m + 1;
			avoidConvTime[row][col] = chosenBase[2] + m + 1;
			// 어차피 앞으로 베이스 캠프를 그래프 상에서 신경쓸 때는 출현했을 때밖에 없음
			graph[chosenBase[0]][chosenBase[1]] = 0;
		}
	}

	private static void setInfo() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][N];
		avoidConvTime = new int[N][N];
		conv = new int[M+1][2];
		base = new int[M+1][2];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				graph[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			// 편의점은 2 + m 으로 표시
			graph[row-1][col-1] = 2 + m;
			conv[m] = new int[] {row-1, col-1};
		}
		
		br.close();
	}
}
