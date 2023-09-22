import java.io.*;
import java.util.*;
import java.util.stream.*;

public class CODETREE범위내에있는점의수2 {

    static final int MAX = 1_000_001;

    static int N, Q;
    static int[] line;
    public static void main(String[] args) throws Exception {
        line = new int[MAX];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        Set<Integer> set = Arrays.stream(br.readLine().split(" ")).
        map(Integer::parseInt).
        collect(Collectors.toCollection(HashSet::new));

        line[0] = set.contains(0) ? 1 : 0;
        for (int i = 1; i < MAX; i++) {
            if (set.contains(i)) line[i] = line[i-1] + 1;
            else line[i] = line[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int points = line[e] - line[s];
            if (set.contains(s)) points++;
            sb.append(points).append("\n");
        }       

        System.out.println(sb);

        br.close();
    }
}