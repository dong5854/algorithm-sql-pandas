import java.io.*;
import java.util.*;

class BOJ17406 {

	static int[][] A;
	static int[][] commands;
	static int[] commandsOrder;
	static boolean[] v;
	// 하, 우, 상, 좌
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static int N, M, K;
	static int ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N+1][M+1];
		commands = new int[K][];
		commandsOrder = new int[K];
		v= new boolean[K];
		ans = Integer.MAX_VALUE;

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 1; c <= M; c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			commands[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}

		perm(0);
		System.out.println(ans);
	}

	static void spin(int[][] copy, int r, int c, int s) {
		int row = r - s; int col = c - s;
		while (s > 0) {
			int temp = copy[row][col];
			int cnt = s * 2;
			for (int i = 0; i < 4; i++) {
				int ct = 0;
				while (ct < cnt) {
					int nr = row + dr[i]; int nc = col + dc[i];
					copy[row][col] = copy[nr][nc];
					row = nr; col = nc;
					ct++;
				}
			}
			copy[row][col+1] = temp;
			row = row + 1; col = col + 1;
			s--;
		}
	}

	static void findMin(int[][] copy) {
		for(int r = 1; r <= N; r++) {
			int sum = 0;
			for(int c = 1; c <= M; c++) {
				sum += copy[r][c];
			}
			ans = Math.min(ans, sum);
		}
	}

	static void perm(int cnt) {
		if(cnt == K) {
			int[][] copy = new int[N+1][M+1];
			for(int r = 1; r <= N; r++) {
				for(int c = 1; c <= M; c++) {
					copy[r][c] = A[r][c];
				}
			}
			for (int idx:commandsOrder) {
				spin(copy, commands[idx][0],commands[idx][1],commands[idx][2]);
			}
			findMin(copy);
			return;
		}
		for (int i = 0; i < K; i++) {
			if (v[i]) continue;
			v[i] = true;
			commandsOrder[cnt] = i;
			perm(cnt+1);
			v[i]=false;
		}
	}
}