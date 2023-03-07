import java.util.*;
import java.io.*;

public class BOJ12865 {
	
	static int N, K;
	static int[][] dp;
	static int[] weights;
	static int[] values;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[N+1][K+1];
		weights = new int[N+1];
		values  = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int weight = Integer.parseInt(st.nextToken());
			int value  = Integer.parseInt(st.nextToken());
			weights[i] = weight;
			values[i] = value;
		}
		
		
		for (int n = 1; n <= N; n++) {
			for (int cap = 1; cap <= K; cap++) {
				if (weights[n] > cap) {	// 물건이 들어가지 않으면,
					dp[n][cap] = dp[n-1][cap];	// 전에꺼 그대로 가져온다~
				} else {	// 물건이 들어가면,
					 // 이 물건을 넣었들 때랑 안넣었을 때 중 더 가치가 높은걸로 고른다.
					dp[n][cap] = Math.max(dp[n-1][cap], dp[n-1][cap-weights[n]] + values[n]); 
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}