class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLength = 0;
        String ans = "";

        // 하나씩 순회
        for (int i = 0; i < len; i++) {
            // 홀수
            int l = i; int r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r-l+1) > maxLength) {
                    maxLength = r-l+1;
                    ans = s.substring(l, r+1);
                }
                l--;
                r++;
            }

            // 짝수
            l = i; r = i+1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r-l+1) > maxLength) {
                    maxLength = r-l+1;
                    ans = s.substring(l, r+1);
                }
                l--;
                r++;
            }
        }
        return ans;
    }
}