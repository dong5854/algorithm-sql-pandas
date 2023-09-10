import java.io.*;
import java.util.*;
import java.util.stream.*;

public class CODETREE마지막으로남은숫자 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        PriorityQueue<Integer> pq = Arrays.stream(br.readLine().split(" ")).
        map(Integer::parseInt).
        collect(Collectors.toCollection(()-> new PriorityQueue<>((a, b) -> -Integer.compare(a,b))));

        while(pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            if ((first - second) == 0) continue;
            pq.add(first - second);
        }

        if (pq.isEmpty()) System.out.println(-1);
        else System.out.println(pq.poll());

        br.close();
    }
}