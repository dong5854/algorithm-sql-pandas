// https://leetcode.com/problems/pascals-triangle/description/
import java.util.*;;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        int row = 0;
        while(row < numRows) {
            int items = row + 1;
            for(int i = 0; i < items; i++) {
                if (i == 0) {
                    ans.add(new ArrayList<>());
                    ans.get(row).add(1);
                }
                else if (i == items - 1) ans.get(row).add(1);
                else {
                    ans.get(row).add(ans.get(row-1).get(i-1) + ans.get(row-1).get(i));
                }
            }
            row++;
        }
        return ans;
    }
}