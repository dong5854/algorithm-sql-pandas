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
/**
 * 2023-09-05
 */
// import java.io.*;
// import java.util.*;

// public class Main {

//     static int N, M;
//     static List<String> groupOne = new ArrayList<>();
//     static List<String> groupTwo = new ArrayList<>();

//     public static boolean valid(int x, int y, int z) {
//         Set<String> set = new HashSet<>();

//         // groupOne
//         for (int i = 0; i < N; i++) {
//             StringBuilder sb = new StringBuilder();
//             sb.append(groupOne.get(i).charAt(x));
//             sb.append(groupOne.get(i).charAt(y));
//             sb.append(groupOne.get(i).charAt(z));
//             set.add(sb.toString());
//         }

//         // groupTwo
//         for (int i = 0; i < N; i++) {
//             StringBuilder sb = new StringBuilder();
//             sb.append(groupTwo.get(i).charAt(x));
//             sb.append(groupTwo.get(i).charAt(y));
//             sb.append(groupTwo.get(i).charAt(z));
//             if (set.contains(sb.toString())) return false;
//         }

//         return true;
//     }

//     public static void main(String[] args) throws Exception {
//         int ans = 0;

//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//         N = Integer.parseInt(st.nextToken());
//         M = Integer.parseInt(st.nextToken());

//         for (int i = 0; i < N; i++) {
//             groupOne.add(br.readLine());
//         }

//         for (int i = 0; i < N; i++) {
//             groupTwo.add(br.readLine());
//         }

//         for (int i = 0; i < M; i++) {
//             for (int j = i + 1; j < M; j++) {
//                 for (int k = j + 1; k < M; k++) {
//                    if (valid(i, j, k)) ans++; 
//                 }
//             }
//         }

//         System.out.println(ans);

//         br.close();
//     }
// }