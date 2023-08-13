// https://leetcode.com/problems/number-of-provinces/description/
class Solution {

    boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        visited = new boolean[isConnected.length];

        for(int i = 0; i < isConnected.length; i++) {
            ans += dfs(isConnected, i);
        }
        return ans;
    }

    public int dfs(int[][] isConnected, int cur) {
        if (visited[cur]) return 0;
        visited[cur] = true;

        for(int i = 0; i < isConnected[cur].length; i++) {
            if (isConnected[cur][i] == 1) dfs(isConnected, i);
        }

        return 1;
    }
}

/**
 * UnionFind로 푼 방법, 느리고 복잡
 */
// class UnionFind {

//     private int[] root;
//     private int[] rank;

//     public UnionFind(int size) {
//         root = new int[size];
//         rank = new int[size];
//         for (int i = 0; i < size; i++) {
//             root[i] = i;
//             rank[i] = 1;
//         }
//     }

//     public int find(int x) {
//         if (x == root[x]) {
//             return x;
//         }
//         return root[x] = find(root[x]);
//     }

//     public void union(int x, int y) {
//         int rootX = find(x);
//         int rootY = find(y);
//         if (rootX != rootY) {
//             if (rank[rootX] > rank[rootY]) {
//                 root[rootY] = rootX;
//             } else if (rank[rootX] < rank[rootY]) {
//                 root[rootX] = rootY;
//             } else {
//                 root[rootY] = rootX;
//                 rank[rootX] += 1;
//             }
//         }
//     }

//     public int count() {
//         Set<Integer> set = new HashSet<>();
//         for (int r : root) {
//             set.add(find(r));
//         }
//         return set.size();
//     }
// }

// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         UnionFind uf = new UnionFind(isConnected.length);
//         for (int from = 0; from < isConnected.length; from++) {
//             for (int to = 0; to < isConnected.length; to++) {
//                 if (isConnected[from][to] == 1) uf.union(from, to);
//             }
//         }

//         return uf.count();
//     }
// }