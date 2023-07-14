class Solution {
    public int equalPairs(int[][] grid) {

        Map<String, Integer> map = new HashMap<>();

        for (int[] row : grid) {
            StringBuilder sb = new StringBuilder();
            for (int r : row) {
                sb.append(r);
                sb.append(',');
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }

        int ans = 0;

        for (int c = 0; c < grid[0].length; c++) {
            StringBuilder sb = new StringBuilder();
            for (int r = 0; r < grid[c].length; r++) {
                sb.append(grid[r][c]);
                sb.append(',');
            }

            if (map.containsKey(sb.toString())) {
                ans += map.get(sb.toString());
            }
        }

        return ans;
    }
}