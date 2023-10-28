import java.util.*;
import java.io.*;

class BOJ1260 {
	
	static int N, M, V;
	static List<Integer>[] graph;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		// 그래프 생성
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 그래프 값 추가
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()); int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}
		
		// 그래프 정렬, 정점 번호가 작은 것부터 방문하기 위해
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		
		boolean[] visited = new boolean[N+1];
		dfs(V, visited);
		sb.append("\n");
		
		visited = new boolean[N+1];
		bfs(V, visited);
		
		System.out.println(sb);
	}

	static void dfs(int v, boolean[] visited) {
		if (visited[v]) return;
		visited[v] = true;
		sb.append(v).append(" ");
		
		for (int nv : graph[v]) {
			dfs(nv, visited);
		}
	}
	
	static void bfs(int v, boolean[] visited) {
		visited[v] = true;
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(v);
		
		while(!queue.isEmpty()) {
			v = queue.poll();
			sb.append(v).append(" ");
			for (int nv : graph[v]) {
				if (visited[nv]) continue;
				visited[nv] = true;
				queue.add(nv);
			}
		}
	}
}