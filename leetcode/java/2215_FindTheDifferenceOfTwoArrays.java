import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> numOne = new HashSet<>();
        Set<Integer> numTwo = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            numOne.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            numTwo.add(nums2[i]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> numOneAns = new ArrayList<>();
        // num1
        for (Integer n : numOne) {
            if (!numTwo.contains(n)) numOneAns.add(n);
        }

        List<Integer> numTwoAns = new ArrayList<>();
        // num2
        for (Integer n : numTwo) {
            if (!numOne.contains(n)) numTwoAns.add(n);
        }

        ans.add(numOneAns);
        ans.add(numTwoAns);

        return ans;
    }
}