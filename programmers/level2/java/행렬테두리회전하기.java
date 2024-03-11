import java.util.*;


class 행렬테두리회전하기 {
    
    static int[][] graph;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        graph = new int[rows+1][columns+1];
        int[] ans = new int[queries.length];
        
        int num = 1;
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= columns; c++) {
                graph[r][c] = num++;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            ans[i] = spin(queries[i]);
        }
        
        return ans;
    }
    
    public int spin(int[] query) {
        int min = Integer.MAX_VALUE;
        
        int x1 = query[0]; int y1 = query[1];
        int x2 = query[2]; int y2 = query[3];
        
        int temp = graph[x1][y1];
        
        // 좌
        for (int x = x1; x < x2; x++) {
            graph[x][y1] = graph[x+1][y1];
            min = Math.min(min, graph[x][y1]);
        }
        // 하
        for (int y = y1; y < y2; y++) {
            graph[x2][y] = graph[x2][y+1];
            min = Math.min(min, graph[x2][y]);
        }
        // 우
        for (int x = x2; x > x1; x--) {
            graph[x][y2] = graph[x-1][y2];
            min = Math.min(min, graph[x][y2]);
        }
        // 상
        for (int y = y2; y > y1; y--) {
            graph[x1][y] = graph[x1][y-1];
            min = Math.min(min, graph[x1][y]);
        }
        
        graph[x1][y1+1] = temp;
        min = Math.min(min, graph[x1][y1+1]);
        return min;
    }
}