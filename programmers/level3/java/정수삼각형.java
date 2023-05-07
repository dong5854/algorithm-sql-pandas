import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int level = triangle.length - 1;
        
        System.out.println(Arrays.toString(triangle[level]));
        
        for (int l = level - 1; l >= 0; l--) {
            for (int i = 0; i < triangle[l].length; i++) {
                triangle[l][i] += Math.max(triangle[l+1][i], triangle[l+1][i+1]);
            }
        }
        return triangle[0][0];
    }
}