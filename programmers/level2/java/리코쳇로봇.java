import java.util.*;

class 리코쳇로봇 {

    static final int[] dr = {0,0,-1,1};
    static final int[] dc = {1,-1,0,0};

    char[][] boardGame;
    boolean[][] visited;

    public int solution(String[] board) {

        visited = new boolean[board.length][board[0].length()];
        boardGame = new char[board.length][board[0].length()];

        int startRow = -1;
        int startCol = -1;

        int endRow = -1;
        int endCol = -1;

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length(); c++) {
                boardGame[r][c] = board[r].charAt(c);
                if (boardGame[r][c] == 'R') {
                    startRow = r;
                    startCol = c;
                } else if (boardGame[r][c] == 'G') {
                    endRow = r;
                    endCol = c;
                }
            }
        }

        return bfs(startRow, startCol, endRow, endCol);
    }

    public int bfs(int sr, int sc, int er, int ec) {
        ArrayDeque<int[]> q = new ArrayDeque<>(); // {row, col, cnt}
        q.add(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while(!q.isEmpty()) {
            int[] rcc = q.poll();
            int cRow = rcc[0];
            int cCol = rcc[1];
            int cCnt = rcc[2];
            for (int i = 0; i < 4; i++) {
                int nRow = cRow;
                int nCol = cCol;
                while (nRow+dr[i]>=0&&nCol+dc[i]>=0&&nRow+dr[i]<boardGame.length&&nCol+dc[i]<boardGame[0].length&&boardGame[nRow+dr[i]][nCol+dc[i]]!='D') {
                    nRow = nRow + dr[i];
                    nCol = nCol + dc[i];
                }
                if (boardGame[nRow][nCol] == 'G') return cCnt + 1;
                if (visited[nRow][nCol]) continue;
                visited[nRow][nCol] = true;
                q.add(new int[]{nRow, nCol, cCnt+1});
            }
        }
        return -1;
    }

}