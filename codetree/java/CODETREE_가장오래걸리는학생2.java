import java.io.*;
import java.util.*;

public class CODETREE_가장오래걸리는학생2 {

    static int N, M;

    static class Node implements Comparable<Node>{
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n) {
            return this.dist - n.dist;
        }
    }

    static List<Node>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[to].add(new Node(from, dist));
        }

        int[] distance = new int[N+1];
        for (int i = 1; i <= N; i++) {
            distance[i] = (int)1e9;
        }

        distance[N] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(N, 0));
        
        while(!pq.isEmpty()) {
            int minIdx = pq.peek().idx;
            int minDist = pq.peek().dist;
            pq.poll();

            if (minDist != distance[minIdx])
                continue;

            for (int i = 0; i < graph[minIdx].size(); i++) {
                int targetIdx = graph[minIdx].get(i).idx;
                int targetDist = graph[minIdx].get(i).dist;

                int nextDist = distance[minIdx] + targetDist;
                if (distance[targetIdx] > nextDist) {
                    distance[targetIdx] = nextDist;
                    pq.add(new Node(targetIdx, nextDist));
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < N; i++) {
            ans = Math.max(ans, distance[i]);
        }

        System.out.println(ans);

        br.close();
    }
}