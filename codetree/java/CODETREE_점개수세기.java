import java.io.*;
import java.util.*;
import java.util.stream.*;

public class CODETREE_점개수세기 {

    static int n,q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        
        Map<Integer, Integer> map = new HashMap<>();

        TreeSet<Integer> points = Arrays.stream(br.readLine().split(" ")).
        map(Integer::parseInt).
        collect(Collectors.toCollection(TreeSet::new));

        int cnt = 0;
        for (int point : points) {
            map.put(point, cnt++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            Integer newS = points.ceiling(s);
            if (newS == null) {
                sb.append(0).append("\n");
                continue;
            }
            Integer newE = points.floor(e);
            if (newE == null) {
                sb.append(0).append("\n");
                continue;
            }
            sb.append(map.get(newE) - map.get(newS) + 1).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}