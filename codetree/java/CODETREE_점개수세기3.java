import java.io.*;
import java.util.*;
import java.util.stream.*;

public class CODETREE_점개수세기3 {

    static int n,q;

    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        List<Integer> list = Arrays.stream(br.readLine().split(" ")).
        map(Integer::parseInt).
        sorted().
        collect(Collectors.toCollection(ArrayList::new));

        int cnt = 0;
        for (Integer val : list) {
            map.put(val, cnt++);
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(map.get(end) - map.get(start) + 1);
        }

        br.close();
    }
}