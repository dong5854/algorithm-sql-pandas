import java.io.*;
import java.util.*;

public class BOJ15961 {

  static int N, d, k, c;
  static int[] sushi;
  static int[] sushiType;

  public static void main(String[] args) throws Exception {
    getInput();
    int type = 1; // 쿠폰으로 하나는 먹어봄
    for (int i = 0; i < k; i++) {
      if (sushiType[sushi[i]] == 0) {
        type++;
      }
      sushiType[sushi[i]]++;
    }

    int ans = 0;
    int idx = 0;
    while (++idx < N) {
      // 초밥 빼기
      sushiType[sushi[idx - 1]]--;
      // 남은 초밥 개수에 따라 종류 줄이기
      if (sushiType[sushi[idx - 1]] == 0) {
        type--;
      }
      // 다음 초밥 추가
      int nxtIdx = (idx + k - 1) % N;
      if (sushiType[sushi[nxtIdx]] == 0) {
        type++;
      }
      sushiType[sushi[nxtIdx]]++;
      ans = Math.max(ans, type);
    }
    System.out.println(ans);
  }

  private static void getInput() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    sushi = new int[N];
    sushiType = new int[d + 1];
    sushiType[c] = 1; // 쿠폰으로 들고시작
    for (int i = 0; i < N; i++) {
      sushi[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }
}
