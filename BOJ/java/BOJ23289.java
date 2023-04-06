import java.io.*;
import java.util.*;

class BOJ23289 {

  // 0 , 우, 좌, 위, 아래
  static final int[] dr = { 0, 0, 0, -1, 1 };
  static final int[] dc = { 0, 1, -1, 0, 0 };

  static int R, C, K;
  static int W;
  static int choco;
  static int[][] wallInfo;
  static int[][] tempInfo;
  static List<int[]> onPungGi;
  static List<int[]> toInspect;

  public static void main(String[] args) throws Exception {
    getInfos();
    choco = 0;
    while (choco < 101) { // 만약, 먹는 초콜릿의 개수가 100을 넘어가면 101을 출력
      wind(); // 온풍기에서 바람이 한번 나옴
      adjust(); // 온도가 조절됨
      decrease(); // 온도가 1 이상인 가장 바깥쪽 칸의 온도가 1씩 감소
      choco++; // 초콜릿을 하나 먹는다.
      if (inspectTemp()) { // 조사하는 모든 칸의 온도가 K 이상이 되었는지 검사. 모든 칸의 온도가 K이상이면 테스트를 중단하고, 아니면 1부터 다시 시작한다.
        break;
      }
    }

    System.out.println(choco);
  }

  private static boolean inspectTemp() {
    for (int[] rc : toInspect) {
      int row = rc[0];
      int col = rc[1];
      if (tempInfo[row][col] < K) {
        return false;
      }
    }
    return true;
  }

  private static void decrease() {
    for (int r = 1; r <= R; r++) {
      // 좌측
      if (tempInfo[r][1] > 0) {
        tempInfo[r][1]--;
      }
      // 우측
      if (tempInfo[r][C] > 0) {
        tempInfo[r][C]--;
      }
    }

    for (int c = 2; c < C; c++) {
      if (tempInfo[1][c] > 0) {
        tempInfo[1][c]--;
      }
      if (tempInfo[R][c] > 0) {
        tempInfo[R][c]--;
      }
    }
  }

  private static void adjust() {
    int[][] tempTemp = new int[R + 1][C + 1];
    for (int r = 1; r <= R; r++) {
      for (int c = 1; c <= C; c++) {
        tempTemp[r][c] += tempInfo[r][c];
        for (int dir = 1; dir <= 4; dir++) {
          int nRow = r + dr[dir];
          int nCol = c + dc[dir];
          // 범위 밖
          if (nRow < 1 || nCol < 1 || nRow > R || nCol > C)
            continue;
          // 벽에 막힘
          if (dir == 1 && ((wallInfo[nRow][nCol] & (1 << 2)) != 0))
            continue;
          if (dir == 2 && ((wallInfo[nRow][nCol] & (1 << 1)) != 0))
            continue;
          if (dir == 3 && ((wallInfo[nRow][nCol] & (1 << 4)) != 0))
            continue;
          if (dir == 4 && ((wallInfo[nRow][nCol] & (1 << 3)) != 0))
            continue;
          if (tempInfo[r][c] < tempInfo[nRow][nCol])
            continue; // 현재 온도가 더 낮으면 퍼지지 않는당.
          int diff = tempInfo[r][c] - tempInfo[nRow][nCol]; // 온도 차이
          diff = diff / 4; // 온도 차이 / 4
          tempTemp[r][c] -= diff; // 내려주고,
          tempTemp[nRow][nCol] += diff; // 올려준다.
        }
      }
    }
    tempInfo = tempTemp;
  }

  private static void wind() {
    for (int[] rcd : onPungGi) {
      int[][] tempTemp = new int[R + 1][C + 1];
      int row = rcd[0];
      int col = rcd[1];
      int dir = rcd[2];
      Queue<int[]> q = new ArrayDeque<>();
      q.add(new int[] { row + dr[dir], col + dc[dir], 5 });
      while (!q.isEmpty()) {
        int[] polled = q.poll();
        int cRow = polled[0];
        int cCol = polled[1];
        int cVal = polled[2];
        tempTemp[cRow][cCol] = cVal;
        // 앞, 앞위, 앞아래
        for (int i = 0; i < 3; i++) {
          int nRow = -1;
          int nCol = -1;
          if (i == 0) { // 앞
            nRow = cRow + dr[dir];
            nCol = cCol + dc[dir];
          } else if (i == 1) {
            if (dir == 1 || dir == 2) { // 좌우 - > 위
              nRow = cRow + dr[3];
              nCol = cCol + dc[3];
              // 범위 밖
              if (nRow < 1 || nCol < 1 || nRow > R || nCol > C)
                continue;
              if (((wallInfo[nRow][nCol] & (1 << 4)) != 0))
                continue; // 간 곳의 아래가 막혀있으면 안됨
              nRow += dr[dir];
              nCol += dc[dir];
            } else if (dir == 3 || dir == 4) { // 위아래 -> 우
              nRow = cRow + dr[1];
              nCol = cCol + dc[1];
              // 범위 밖
              if (nRow < 1 || nCol < 1 || nRow > R || nCol > C)
                continue;
              if (((wallInfo[nRow][nCol] & (1 << 2)) != 0))
                continue; // 간 곳의 왼쪽이 막혀있으면 안됨
              nRow += dr[dir];
              nCol += dc[dir];
            }
          } else if (i == 2) {
            if (dir == 1 || dir == 2) { // 좌우 -> 아래
              nRow = cRow + dr[4];
              nCol = cCol + dc[4];
              if (nRow < 1 || nCol < 1 || nRow > R || nCol > C)
                continue;
              if (((wallInfo[nRow][nCol] & (1 << 3)) != 0))
                continue; // 간 곳의 위가 막혀있으면 안됨
              nRow += dr[dir];
              nCol += dc[dir];
            } else if (dir == 3 || dir == 4) { // 위아래 -> 좌
              nRow = cRow + dr[2];
              nCol = cCol + dc[2];
              if (nRow < 1 || nCol < 1 || nRow > R || nCol > C)
                continue;
              if (((wallInfo[nRow][nCol] & (1 << 1)) != 0))
                continue; // 간 곳의 오른쪽이 막혀있으면 안됨
              nRow += dr[dir];
              nCol += dc[dir];
            }
          }
          // 범위 밖
          if (nRow < 1 || nCol < 1 || nRow > R || nCol > C)
            continue;
          // 벽으로 막힘
          if (dir == 1 && ((wallInfo[nRow][nCol] & (1 << 2)) != 0))
            continue;
          if (dir == 2 && ((wallInfo[nRow][nCol] & (1 << 1)) != 0))
            continue;
          if (dir == 3 && ((wallInfo[nRow][nCol] & (1 << 4)) != 0))
            continue;
          if (dir == 4 && ((wallInfo[nRow][nCol] & (1 << 3)) != 0))
            continue;
          if (cVal - 1 > 0) {
            q.add(new int[] { nRow, nCol, cVal - 1 });
          }
        }
      }

      // 임시 저장한 온도 더하기
      for (int r = 1; r <= R; r++) {
        for (int c = 1; c <= C; c++) {
          tempInfo[r][c] += tempTemp[r][c];
        }
      }
    }
  }

  static void getInfos() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    wallInfo = new int[R + 1][C + 1];
    tempInfo = new int[R + 1][C + 1];
    onPungGi = new ArrayList<>();
    toInspect = new ArrayList<>();

    for (int r = 1; r <= R; r++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int c = 1; c <= C; c++) {
        int val = Integer.parseInt(st.nextToken());
        if (val >= 1 && val <= 4) {
          onPungGi.add(new int[] { r, c, val });
        } else if (val == 5) {
          toInspect.add(new int[] { r, c });
        }
      }
    }

    // 벽세우기
    W = Integer.parseInt(br.readLine());
    for (int w = 0; w < W; w++) {
      st = new StringTokenizer(br.readLine(), " ");
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());

      if (t == 0) { // 위아래
        wallInfo[x][y] |= (1 << 3); // 위에 벽있음
        wallInfo[x - 1][y] |= (1 << 4); // 아래에 벽있음
      } else if (t == 1) { // 좌우
        wallInfo[x][y] |= (1 << 1); // 오른쪽에 벽있음
        wallInfo[x][y + 1] |= (1 << 2); // 왼쪽에 벽있음
      }
    }

    br.close();
  }
}