import java.io.*;
import java.util.*;

public class BOJ2098 {
	
	static final int INF= 987654321;
	static int N;
	static int[][] cities;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		// 입력 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cities = new int[N][N];

		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				cities[r][c] = Integer.parseInt(st.nextToken());
				if (cities[r][c] == 0)
					cities[r][c] = INF;
			}
		}
		// 입력 끝

		dp = new int[1 << N][N];

		System.out.println(TSP(0, 0));

		br.close();
	}

	// visited: 이미 방문한 도시 체크(비트마스크)
	// now :    이번에 지날 도시
	private static int TSP(int visited, int now) {
		// now 번 도시 방문 처리
		visited |= 1 << now;
		if (visited == (1 << N) - 1) { // 모든 도시를 방문한 경우
			if (cities[now][0] != INF) // 출발도시로 돌아갈 수 있어야한다.
				return cities[now][0];
			return INF; // 출발 도시로 돌아가지 못하면 INF 반환
		}

		if (dp[visited][now] > 0)	// 이미 최솟값이 갱신된 경우
			return dp[visited][now];

		dp[visited][now] = INF;
		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) != 0) // 이미 방문한 경우 스킵
				continue;
			if (cities[now][i] == INF) // 길이 없거나 자기 자신 스킵
				continue;
			int temp = cities[now][i] + TSP(visited, i);
			if (dp[visited][now] > temp)
				dp[visited][now] = temp;
		}
		return dp[visited][now];
	}
}