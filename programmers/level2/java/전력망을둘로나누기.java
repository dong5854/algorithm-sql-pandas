import java.util.*;

class UnionFind {
    int[] root;
    Integer[] cnt;
    
    public UnionFind(int n) {
        root = new int[n+1];
        cnt = new Integer[n+1];
        for (int i = 0; i <= n; i++) {
            root[i] = i;
            cnt[i] = 1;
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
        if (cnt[rootA] < cnt[rootB]) {  // 더 큰 루트에 편입
            root[rootA] = rootB;
            cnt[rootB] += cnt[rootA];
        } else if (cnt[rootA] >= cnt[rootB]) {
            root[rootB] = rootA;
            cnt[rootA] += cnt[rootB];
        }
    }
    
    public int getDiff() {
        Arrays.sort(cnt, Collections.reverseOrder());
        return cnt[0] - cnt[1];
    }
}

class 전력망을둘로나누기 {
    
    int ans = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        for (int i = 0; i < n; i++) {
            UnionFind unionFind = new UnionFind(n);
            for (int w = 0; w < wires.length; w++) {
                if (w == i) continue;
                unionFind.union(wires[w][0], wires[w][1]);
            }
            ans = Math.min(ans, unionFind.getDiff());
        }
        return ans;
    }
}