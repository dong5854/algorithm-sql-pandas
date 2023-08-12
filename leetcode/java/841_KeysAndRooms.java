import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> keySet = new HashSet<>();
        keySet.add(0);
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        dfs(rooms, 0, keySet, visited);
        
        boolean ans = true;
        for (boolean v : visited) {
            if (v == false) ans = false;
        }
        return ans;
    }

    private void dfs(List<List<Integer>> rooms, int visit, Set<Integer> keySet, boolean[] visited) {
        for (int i = 0; i < rooms.get(visit).size(); i++) {
            keySet.add(rooms.get(visit).get(i));
        }

        for (int i = 0; i < rooms.get(visit).size(); i++) {
            int key = rooms.get(visit).get(i);
            if (!keySet.contains(key)) continue;
            if (visited[key] == true) continue;
            visited[key] = true;
            dfs(rooms, key, keySet, visited);
        }
    }
}