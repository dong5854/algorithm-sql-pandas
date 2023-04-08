import java.util.*;
import java.io.*;

class Solution탈주범검거 {

	// 0 , 우, 좌, 하, 상
	static final int[] dr = { 0, 0, 0, 1, -1 };
	static final int[] dc = { 0, 1, -1, 0, 0 };

	static int N, M;
	static int R, C;
	static int L;

	static int[][] graph;
	static boolean[][] v;

	static int ans;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			ans = 1;

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			graph = new int[N][M];
			v = new boolean[N][M];

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < M; c++) {
					int type = Integer.parseInt(st.nextToken());
					// 상 (1 << 4), 하 (1 << 3), 좌 (1 << 2), 우 (1 << 1)
					if (type == 1) { // 상하좌우
						graph[r][c] = ((1 << 4) | (1 << 3) | (1 << 2) | (1 << 1));
					} else if (type == 2) { // 상하
						graph[r][c] = ((1 << 4) | (1 << 3));
					} else if (type == 3) { // 좌우
						graph[r][c] = ((1 << 2) | (1 << 1));
					} else if (type == 4) { // 상우
						graph[r][c] = ((1 << 4) | (1 << 1));
					} else if (type == 5) { // 하우
						graph[r][c] = ((1 << 3) | (1 << 1));
					} else if (type == 6) { // 하좌
						graph[r][c] = ((1 << 3) | (1 << 2));
					} else if (type == 7) { // 상좌
						graph[r][c] = ((1 << 4) | (1 << 2));
					}
				}
			}

			bfs(R, C);

			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	static void bfs(int row, int col) {
		// 방문처리
		v[row][col] = true;
		if (L == 1)
			return;
		// row, col, cnt
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { row, col, 1 });
		while (!q.isEmpty()) {
			int[] polled = q.poll();
			int cRow = polled[0];
			int cCol = polled[1];
			int cCnt = polled[2];
			// 1: 우, 2 : 좌, 3: 하, 4 : 상
			for (int d = 1; d <= 4; d++) {
				int nRow = cRow + dr[d];
				int nCol = cCol + dc[d];
				if (nRow >= N || nCol >= M || nRow < 0 || nCol < 0) // 범위 밖
					continue;
				if (v[nRow][nCol]) // 이미 방문
					continue;
				if ((graph[cRow][cCol] & (1 << d)) == 0) // 현재 파이프의 해당 출구 없음
					continue;
				if (d == 1 && (graph[nRow][nCol] & (1 << 2)) == 0) // 우 -> 좌 못감
					continue;
				if (d == 2 && (graph[nRow][nCol] & (1 << 1)) == 0) // 좌 -> 우 못감
					continue;
				if (d == 3 && (graph[nRow][nCol] & (1 << 4)) == 0) // 하 -> 상 못감
					continue;
				if (d == 4 && (graph[nRow][nCol] & (1 << 3)) == 0) // 우 -> 좌 못감
					continue;

				int nCnt = cCnt + 1;
				v[nRow][nCol] = true;
				ans++;
				if (nCnt < L) {
					q.add(new int[] { nRow, nCol, nCnt });
				}
			}
		}
	}
}