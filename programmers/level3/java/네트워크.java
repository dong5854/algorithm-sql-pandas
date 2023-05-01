class UnionFind {
    
  int n;
  int[] root;
  
  public UnionFind(int n) {
      this.n = n;
      root = new int[n];
      for (int i = 0; i < n; i++) {
          root[i] = i;
      }
  }
  
  int find(int node) {
      if (root[node] == node) {
          return node;
      }
      return root[node] = find(root[node]);
  }
  
  void union(int a, int b) {
      int rootA = find(a);
      int rootB = find(b);
      if (rootA == rootB) return;
      n--;
      root[rootA] = rootB;
      return;
  }
}


class Solution {
  public int solution(int n, int[][] computers) {
      UnionFind uf = new UnionFind(n);
      for (int a = 0; a < n; a++) {
          for (int b = 0; b < n; b++) {
              if (computers[a][b] == 1) {
                  uf.union(a, b);
              }
          }
      }
      return uf.n;
  }
}