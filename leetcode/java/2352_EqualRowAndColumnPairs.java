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

// 다른 풀이 방식
// class Solution {
//     public int equalPairs(int[][] grid) {
//         int pair=0;
//         int temp=0;
//         int row=0;
//         while(temp<=grid.length-1)
//         {
//             HashMap<Integer,Integer> map=new HashMap<>();
//             for(int j=0;j<grid.length;j++)
//             {
//                 map.put(j,grid[row][j]);
//             }
//             for(int i=0;i<grid.length;i++)
//             {
//                 int curr=0;
//                 for(int k=0;k<grid.length;k++)
//                 {
//                     if(map.get(k)!=grid[k][i])
//                     {
//                         curr=0;
//                         break;
//                     }
//                     else
//                         curr=1;
//                 }
//                 pair+=curr;
//             }
//             row++;
//             temp++;
//         }
//         return pair;
//     }
// }
