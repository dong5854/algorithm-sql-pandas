import java.util.*;

class 아이템줍기 {

    // 상 1, 우 2, 하 3, 좌 4
    static final int[] dx = {0,0,-1,1};
    static final int[] dy = {1,-1,0,0};

    static int[][] graph;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        graph = new int[101][101];
        for(int i=0; i<rectangle.length; i++){
            fill(2*rectangle[i][0], 2*rectangle[i][1], 2*rectangle[i][2], 2*rectangle[i][3]);
        }

        return findItem(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    public int findItem(int characterX,int characterY,int itemX,int itemY) {
        boolean[][] visited = new boolean[101][101];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {characterX, characterY, 0});
        visited[characterX][characterY] = true;
        while(!q.isEmpty()) {
            int[] xyc = q.poll();
            int cx = xyc[0];
            int cy = xyc[1];
            int cCnt = xyc[2];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;
                if (graph[nx][ny] != 1) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if (nx == itemX && ny == itemY) {
                    return cCnt + 1;
                }
                q.add(new int[] {nx, ny, cCnt + 1});
            }
        }
        return -1;
    }

    public void fill(int x1, int y1, int x2, int y2){
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                if(graph[i][j]==2) continue;
                graph[i][j]=2;
                if(i==x1||i==x2||j==y1||j==y2){
                    graph[i][j]=1;
                }
            }
        }
    }
}
