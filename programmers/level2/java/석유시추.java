import java.util.*;
public class 석유시추 {

    final int[] dx = {0, -1, 1, 0};
    final int[] dy = {1, 0, 0, -1};

    Map<Integer, Integer> oilMap = new HashMap<>();
    int[][] numberedLand;
    int[][] land;

    public int solution(int[][] land) {
        this.land = land;
        this.numberedLand = new int[land.length][land[0].length];

        int markVal = 0;
        for (int row = 0; row < land.length; row++) {
            for (int col = 0; col < land[0].length; col++) {
                if (land[row][col] == 0 || numberedLand[row][col] != 0) continue;
                bfs(row, col, ++markVal);
            }
        }

        int ans = 0;
        for (int col = 0; col < land[0].length; col++) {
            boolean[] v = new boolean[oilMap.size()+1];
            int temp = 0;
            for (int row = 0; row < land.length; row++) {
                if (numberedLand[row][col] == 0) continue;
                if (v[numberedLand[row][col]]) continue;
                v[numberedLand[row][col]] = true;
                temp += oilMap.get(numberedLand[row][col]);
            }
            if (temp > ans) ans = temp;
        }
        return ans;
    }

    public void bfs(int row, int col, int markVal) {
        int cnt = 1;
        this.numberedLand[row][col] = markVal;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{row, col});

        while(!deque.isEmpty()) {
            int[] cur = deque.poll();
            int cx = cur[0];
            int cy = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || ny < 0 || nx >= land.length || ny >= land[0].length) continue;
                if (numberedLand[nx][ny] != 0) continue;
                if (land[nx][ny] == 0) continue;
                numberedLand[nx][ny] = markVal;
                deque.add(new int[]{nx, ny});
                cnt++;
            }
        }

        oilMap.put(markVal,cnt);
    }

    public static void main(String[] args) {
        석유시추 s = new 석유시추();
        System.out.println(
                s.solution(new int[][]
                        {{0, 0, 0, 1, 1, 1, 0, 0},{0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}
                )
        );
    }
}
