import java.io.*;
import java.util.*;

public class CODETREEC_TAG {

  static int ans;

  static int N, M;
  static int[] selected;
  static String[] a;
  static String[] b;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    ans = 0;
    selected = new int[3];

    a = new String[N];
    b = new String[N];

    // A 그룹
    for (int n = 0; n < N; n++) {
      String line = br.readLine();
      a[n] = line;
    }

    // B 그룹
    for (int n = 0; n < N; n++) {
      String line = br.readLine();
      b[n] = line;
    }

    // 조합
    comb(0, 0);

    System.out.println(ans);
    br.close();
  }

  static void comb(int cnt, int start) {
    if (cnt == 3) {
      Set<String> aSet = new HashSet<>();
      for (int n = 0; n < N; n++) {
        StringBuilder sb = new StringBuilder();
        sb.append(a[n].charAt(selected[0])).append(a[n].charAt(selected[1])).append(a[n].charAt(selected[2]));
        aSet.add(sb.toString());
      }

      for (int n = 0; n < N; n++) {
        StringBuilder sb = new StringBuilder();
        sb.append(b[n].charAt(selected[0])).append(b[n].charAt(selected[1])).append(b[n].charAt(selected[2]));
        if (aSet.contains(sb.toString())) {
          return;
        }
      }
      ans++;
      return;
    }

    for (int i = start; i < M; i++) {
      selected[cnt] = i;
      comb(cnt + 1, i + 1);
    }
  }
}
