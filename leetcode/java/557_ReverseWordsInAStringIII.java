// https://leetcode.com/problems/reverse-words-in-a-string-iii/?envType=study-plan&id=algorithm-i
class Solution {
    public String reverseWord(String s) {
        char[] word = s.toCharArray();
        int start = 0;
        int end = word.length - 1;
        while (start < end) {
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;
            start++;
            end--;
        }
        return new String(word);
    }
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String word: words) {
            stringBuilder.append(reverseWord(word));
            if (i != words.length - 1) stringBuilder.append(" ");
            i++;
        }
        return stringBuilder.toString();
    }
}