class Solution {

    String ans;
    String smaller;

    public String gcdOfStrings(String str1, String str2) {
        ans = "";
        smaller = str1.length() < str2.length() ? str1 : str2;
        permutation(str1, str2);
        return ans;
    }

    public void permutation(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx < smaller.length()) {
            sb.append(smaller.charAt(idx++));
            String temp = sb.toString();
            boolean able =true;

            // str1
            for (int i = 0; i < str1.length(); i++) {
                int dividerIdx = i % temp.length();
                if (str1.charAt(i) != temp.charAt(dividerIdx)) {
                    able = false;
                }
            }
            // str2
            for (int i = 0; i < str2.length(); i++) {
                int dividerIdx = i % temp.length();
                if (str2.charAt(i) != temp.charAt(dividerIdx)) {
                    able = false;
                }
            }

            if (able && str1.length() % temp.length() == 0 && str2.length() % temp.length() == 0) {
                ans = temp;
            }
        }
    }
}