class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int flipUsed = 0;
        int cur = 0;
        int idx = 0;
        while (idx < nums.length && (nums[idx] == 1 || flipUsed < k)) {
            if (nums[idx++] == 0) flipUsed++;
            cur++;
        }
        ans = cur;
        int head = 0, tail = idx - 1;
        while (tail < nums.length - 1) {
            // tail이 움직이려면 다음이 1 이거나 flipUsed에 여유가 있어야한다.
            if (nums[tail + 1] == 1 || flipUsed < k) {
                if (nums[++tail] == 0) flipUsed++;
                cur++;
        }
          // 위의 조건이 만족이 안되면 head를 옮겨 flipUsed에 여유가 생기게 해준다.
        else {
            if (nums[head++] == 0) {
                flipUsed--;
            }
            cur--;
        }
        ans = Math.max(ans, cur);
        }
        return ans;
    }
}