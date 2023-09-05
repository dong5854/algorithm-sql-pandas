import java.io.*;
import java.util.*;

public class CODETREE원소의합이0 {

  static int N;
  static int[] A, B, C, D;

  static int ans;
  static Map<Integer, Integer> AB;

  public static void main(String[] args) throws Exception {
    setUp();
    createABMap();
    calculateWithCD();
    System.out.println(ans);
  }

  private static void calculateWithCD() {
    for (int c = 0; c < N; c++) {
      for (int d = 0; d < N; d++) {
        int sum = C[c] + D[d];
        int target = -sum;
        ans += AB.getOrDefault(target, 0);
      }
    }
  }

  private static void createABMap() {
    for (int a = 0; a < N; a++) {
      for (int b = 0; b < N; b++) {
        int sum = A[a] + B[b];
        AB.put(sum, AB.getOrDefault(sum, 0) + 1);
      }
    }
  }

  static void setUp() throws Exception {
    ans = 0;
    AB = new HashMap<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    A = new int[N];
    B = new int[N];
    C = new int[N];
    D = new int[N];
    for (int i = 0; i < 4; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int n = 0; n < N; n++) {
        if (i == 0) {
          A[n] = Integer.parseInt(st.nextToken());
        } else if (i == 1) {
          B[n] = Integer.parseInt(st.nextToken());
        } else if (i == 2) {
          C[n] = Integer.parseInt(st.nextToken());
        } else if (i == 3) {
          D[n] = Integer.parseInt(st.nextToken());
        }
      }
    }
    br.close();
  }
}
/**
 * 2023-09-05 다시풀기
 */
// import java.util.*;
// import java.util.stream.*;
// import java.io.*;

// public class Main {
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());

//         Map<Integer, Integer> abMap = new HashMap<>();
//         Map<Integer, Integer> cdMap = new HashMap<>();

//         int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//         int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//         int[] C = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//         int[] D = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 int abSum = A[i] + B[j];
//                 int cdSum = C[i] + D[j];
//                 abMap.put(abSum, abMap.getOrDefault(abSum, 0) + 1);
//                 cdMap.put(cdSum, cdMap.getOrDefault(cdSum, 0) + 1);
//             }
//         }

//         int ans = 0;
//         for (int num : abMap.keySet()) {
//             if (cdMap.containsKey(-num)) {
//                 ans += abMap.get(num) * cdMap.get(-num);
//             }
//         }

//         System.out.println(ans);

//         br.close();
//     }
// }
