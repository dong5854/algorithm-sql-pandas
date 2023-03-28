import java.util.*;
import java.io.*;

class Solution1952
{
	
	// 1일, 1달, 3달, 1년
	static int[] costs;
	// 월별 사용일
	static int[] months;
	// 월별 사용량
	static int[] ans;
	
	public static void main(String args[]) throws Exception
	{		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T=Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 입력 시작
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			costs =  new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			months = new int[13];	// 1년 12개월
			ans = 	 new int[13];	// 1년 12개월
			Arrays.fill(ans, costs[3]);	// 일단 1년치
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= 12; i++) {
				months[i] = Integer.parseInt(st.nextToken());
			}
			// 입력 끝
			
			dfs(0, 0);
			
			
			sb.append("#").append(test_case).append(" ").append(ans[12]).append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}

	private static void dfs(int cnt, int cost) {
		if (cnt > 12)  return;
		 if (cnt == 12) {
			 ans[12] = Math.min(ans[12], cost);
		 	return;
		 }
//		if (cnt > 12) 	      return;
//		if (ans[cnt] <= cost) return;
//		ans[cnt] = cost;
//		if (cnt == 12) return;
		// 일일권
		dfs(cnt+1, cost + (months[cnt+1] * costs[0]));
		// 한달권
		dfs(cnt+1, cost + costs[1]);
		// 세달권
		dfs(cnt+3, cost + costs[2]);
	}
}