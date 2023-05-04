import java.util.*;

class Solution {
    
    static int[] v;
    static List<Integer>[] nodes;
    
    public int solution(int n, int[][] edge) {
        nodes = new ArrayList[n+1];
        v = new int[n+1];
        for (int i = 1; i <=n; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int[] e : edge) {
            nodes[e[0]].add(e[1]);
            nodes[e[1]].add(e[0]);
        }
        
        int maxVal = bfs(1);
        int ans = 0;
        for (int i : v) {
            if (i == maxVal) {
                ans++;
            }
        }
        
        return ans;
    }
    
    public int bfs(int start) {
        int maxDis = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[start] = 1;
        maxDis = Math.max(maxDis, 1);
        q.add(new int[] {start, 1});
        while(!q.isEmpty()) {
            int[] nc = q.poll();
            int curNode = nc[0];
            int curCnt = nc[1];
            for (int nxtNode : nodes[curNode]) {
                if (v[nxtNode] != 0) continue;
                v[nxtNode] = curCnt + 1;
                maxDis = Math.max(maxDis, curCnt + 1);
                q.add(new int[] {nxtNode, curCnt + 1});
            }
        }
        return maxDis;
    }
}