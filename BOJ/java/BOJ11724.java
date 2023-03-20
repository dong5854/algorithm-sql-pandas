import java.util.*;
import java.io.*;
public class BOJ11724 {

    static class UnionFind {
        int[] root;

        public UnionFind(int nodes) {
            root = new int[nodes + 1];
            for (int i = 0; i <= nodes; i++) {
                root[i] = i;
            }
        }

        public int find(int node) {
            if (node == root[node]) {
                return node;
            }
            return root[node] = find(root[node]);
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return;
            root[rootA] = rootB;
        }

        public int groups() {
            Set<Integer> group = new HashSet<>();
            for (int i = 1; i < root.length; i++) {
                group.add(find(root[i]));
            }
            return group.size();
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        UnionFind unionFind = new UnionFind(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            unionFind.union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        System.out.println(unionFind.groups());
    }
}
