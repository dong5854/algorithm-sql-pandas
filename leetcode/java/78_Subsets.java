// https://leetcode.com/problems/subsets/?envType=study-plan&id=algorithm-ii
import java.util.*;

class Solution {

    List<List<Integer>> ans;
    boolean[] v;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        v = new boolean[nums.length];

        subs(0, nums, v);

        return ans;
    }

    void subs(int cnt, int[] nums, boolean[] v) {
        if (cnt == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (v[i]) temp.add(nums[i]);
            }
            ans.add(temp);
            return;
        }

        v[cnt] = true;
        subs(cnt + 1, nums, v);
        v[cnt] = false;
        subs(cnt + 1, nums, v);
    }
}