import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {
            boolean greatest = true;
            int temp = candies[i] + extraCandies;
            for(int j = 0; j < candies.length; j++) {
                if (candies[j] > temp) {
                    greatest = false;
                }
            }
            ans.add(greatest);
        }

        return ans;
    }
}