import java.util.*;
import java.io.*;

class BOJ3055 {

	// 상, 우, 하, 좌
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	static int N, M;
	static char[][] graph;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int startRow = -1;
		int startCol = -1;
		graph = new char[N][M];
		for (int r = 0; r < N; r++) {
			String row = br.readLine();
			for (int c = 0; c < M; c++) {
				if (row.charAt(c) == 'S') {
					startRow = r;
					startCol = c;
				}
				graph[r][c] = row.charAt(c);
			}
		}

		int ans = bfs(startRow, startCol);
		if (ans == -1) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(ans);
		}

		System.out.println(sb);
		br.close();

	}

	private static int bfs(int row, int col) {
		int curSec = 0;
		boolean[][] v = new boolean[N][M];
		v[row][col] = true;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { row, col, 0 });
		while (!q.isEmpty()) {
			int[] polled = q.poll();
			int cRow = polled[0];
			int cCol = polled[1];
			int cCnt = polled[2];
			for (int d = 0; d < 4; d++) {
				int nRow = cRow + dr[d];
				int nCol = cCol + dc[d];
				if (nRow >= N || nCol >= M || nRow < 0 || nCol < 0)
					continue;
				if (curSec < cCnt + 1) {
					curSec++;
					devilHand();
				}
				if (graph[nRow][nCol] == 'X' || graph[nRow][nCol] == '*')
					continue;
				if (v[nRow][nCol])
					continue;
				if (graph[nRow][nCol] == 'D') {
					return cCnt + 1;
				}
				v[nRow][nCol] = true;
				q.offer(new int[] { nRow, nCol, cCnt + 1 });
			}
		}

		return -1;
	}

	private static void devilHand() {
		// 임시맵에 넣기
		char[][] temp = new char[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (graph[r][c] == '*') {
					for (int d = 0; d < 4; d++) {
						int nRow = r + dr[d];
						int nCol = c + dc[d];
						if (nRow >= N || nCol >= M || nRow < 0 || nCol < 0)
							continue;
						if (graph[nRow][nCol] == 'X' || graph[nRow][nCol] == 'D')
							continue;
						temp[nRow][nCol] = '*';
					}
				}
			}
		}

		// 임시맵에 있는 것들 꺼내기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (temp[r][c] == '*')
					graph[r][c] = '*';
			}
		}
	}
}