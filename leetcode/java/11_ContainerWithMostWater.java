// https://leetcode.com/problems/container-with-most-water/
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        
        while(left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int area = w * h;
            ans = Math.max(ans, area);
            if (height[left] < height[right]) left++;
            else if(height[left] > height[right]) right--;
            else {
                left++;
                right--;
            }
        }
        return ans;
    }
}