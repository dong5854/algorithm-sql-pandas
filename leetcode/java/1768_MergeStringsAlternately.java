class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        while(true) {
            if (word1.length() < idx && word2.length() < idx) break;
            if (word1.length() > idx) {
                sb.append(word1.charAt(idx));   
            }
            if (word2.length() > idx) {
                sb.append(word2.charAt(idx));
            }
            idx++;
        }

        return sb.toString();
    }
}