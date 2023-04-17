import java.io.*;
import java.util.*;

public class BOJ1004 {
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
    public static void main(String[] args) throws Exception{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	
    	for (int test_case = 1; test_case <= T; test_case++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		Point startPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    		Point endPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    		int ans = 0;
    		
    		int n = Integer.parseInt(br.readLine());
    		for (int i =0; i < n; i++) {
    			st = new StringTokenizer(br.readLine(), " ");
    			Point circle = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    			int dist = Integer.parseInt(st.nextToken());
    			boolean startInclude = CircleInclude(circle, startPoint, dist);
    			boolean endInclude = CircleInclude(circle, endPoint, dist);
    			if (startInclude ^ endInclude) {
    				ans++;
    			}
    		}
    		
    		System.out.println(ans);
    	}
    }
    
    static boolean CircleInclude (Point circle, Point point, int dist) {
    	return getDist(circle, point) < dist;
    }
    
    static double getDist (Point a, Point b) {
    	return Math.sqrt(Math.pow(Math.abs(a.x - b.x), 2) + Math.pow(Math.abs(a.y - b.y), 2));
    	
    }
}