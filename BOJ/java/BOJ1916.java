import java.io.*;
import java.util.*;

public class BOJ1916 {

    static int N,M;
    static List<Destination>[] graph;
    static boolean[] v;
    static int[] distance;
    static int ans;

    static class Destination implements Comparable<Destination> {

        int city;
        int cost;
        Destination(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
        @Override
        public int compareTo(Destination o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;

        graph = new ArrayList[N+1]; // 1~N까지
        v = new boolean[N+1];
        distance = new int[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }


        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Destination(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int from = Integer.parseInt(st.nextToken()); int to = Integer.parseInt(st.nextToken());
        if (from == to) {
            System.out.println(1);
            return;
        }

        dijkstra(from);

        System.out.println(distance[to]);
    }

    static void dijkstra(int from) {
        PriorityQueue<Destination> queue = new PriorityQueue<>();
        queue.add(new Destination(from, 0));
        distance[from] = 0;
        while (!queue.isEmpty()) {
            Destination current = queue.poll();
            if (distance[current.city] < current.cost) continue;
            for (int i = 0; i < graph[current.city].size(); i++) {
                Destination to = graph[current.city].get(i);
                int cost = current.cost + to.cost;
                if (cost < distance[to.city]) {
                    distance[to.city] = cost;
                    to.cost = cost;
                    queue.add(to);
                }
            }
        }
    }
}
