// https://leetcode.com/problems/triangle/description/
import java.util.*;
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> below = triangle.get(i + 1);
            List<Integer> current = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                if(below.get(j) < below.get(j+1)) {
                    current.set(j, current.get(j) + below.get(j));
                } else {
                    current.set(j,current.get(j) + below.get(j+1));
                }
            }
        }
        return triangle.get(0).get(0);
    }
}