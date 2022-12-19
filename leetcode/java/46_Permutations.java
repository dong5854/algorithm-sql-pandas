// https://leetcode.com/problems/permutations/description/?envType=study-plan&id=algorithm-i
import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backtracking(ans, nums, new ArrayList<>(), visited);

        return ans;
    }

    public void backtracking(List<List<Integer>> ans, int[] nums, List<Integer> currentNums, boolean[] visited) {
        if (currentNums.size() == nums.length) {
            ans.add(new ArrayList<>(currentNums));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            currentNums.add(nums[i]);
            visited[i] = true;
            backtracking(ans, nums, currentNums, visited);
            currentNums.remove(currentNums.size() - 1);
            visited[i] = false;
        }
    }
}
