import java.io.*;
import java.util.*;

public class CODETREE초대장과번호표 {

  static int N, G;
  static List<Integer>[] personGroup;
  static Set<Integer>[] groups;
  static boolean[] included;
  static ArrayDeque<Integer> q;
  static int ans;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    G = Integer.parseInt(st.nextToken());

    personGroup = new ArrayList[N];
    groups = new HashSet[G];
    included = new boolean[N];
    q = new ArrayDeque<>();
    ans = 0;

    for (int i = 0; i < N; i++) {
      personGroup[i] = new ArrayList<>();
    }

    for (int i = 0; i < G; i++) {
      groups[i] = new HashSet<>();
    }

    for (int g = 0; g < G; g++) {
      st = new StringTokenizer(br.readLine(), " ");
      int size = Integer.parseInt(st.nextToken());
      for (int s = 0; s < size; s++) {
        int person = Integer.parseInt(st.nextToken());
        person--;
        groups[g].add(person);
        personGroup[person].add(g);
      }
    }

    q.add(0);
    included[0] = true;
    while (!q.isEmpty()) {
      int person = q.poll();
      ans++;

      for (int i = 0; i < personGroup[person].size(); i++) {
        int gNum = personGroup[person].get(i);

        groups[gNum].remove(person);
        if (groups[gNum].size() == 1) {
          int pNum = new ArrayList<>(groups[gNum]).get(0);
          if (!included[pNum]) {
            included[pNum] = true;
            q.add(pNum);
          }
        }
      }
    }

    System.out.println(ans);
    br.close();
  }
}
