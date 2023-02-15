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