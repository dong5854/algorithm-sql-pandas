// https://www.acmicpc.net/problem/15685
import java.util.*;
import java.io.*;

public class BOJ15685 {

	static boolean[][] graph;
	static List<Integer> list;
	static int ans;
	
	// 0, 1, 2, 3 방향
	static final int[] dx = {1, 0, -1, 0};
	static final int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		graph = new boolean[101][101];
		ans = 0;
		
		for(int i =0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			// 처음 한칸
			list = new ArrayList<>();
			dragonCurve(x, y, g, d, 0);
		}
		
		
		for (int leftTopX = 0; leftTopX < 100; leftTopX++) {
			for(int leftTopY = 0; leftTopY <100; leftTopY++) {
				if (graph[leftTopX][leftTopY] && graph[leftTopX+1][leftTopY] && graph[leftTopX][leftTopY+1] && graph[leftTopX+1][leftTopY+1]) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
		
		br.close();
	}
	
	public static void dragonCurve(int x, int y, int g, int d, int cnt) {
		if (cnt > g) return; // 세대만큼 진행 완료
		
		// 처음에 움직이고 리스트에 넣어줌
		if (cnt == 0) {
			graph[y][x] = true;
			x += dx[d];
			y += dy[d];
			graph[y][x] = true;
			list.add(d);
		} else {
			int toDraw = list.size() - 1; // 움직일 리스트를 뽑고,
			
			for(int i = toDraw; i >= 0; i--) {
				int dir = list.get(i);	// 전에 움직인 것을 받아옴
				int spinned = spin(dir); // 90도 회전
				x += dx[spinned];
				y += dy[spinned];
				graph[y][x] = true;
				list.add(spinned);	// 다음을 위해 넣어둠
			}
		}
		dragonCurve(x, y, g, d, cnt + 1);
	}
	
	public static int spin(int d) {
		return (d + 1) % 4;
	}
}
