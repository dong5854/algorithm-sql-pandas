class Solution {
    public boolean closeStrings(String word1, String word2) {

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for(int i=0;i<word1.length();i++){
          char ch = word1.charAt(i);
          set1.add(ch);
          cnt1[ch-'a']++;
        }
        for(int i=0;i<word2.length();i++){
          char ch=word2.charAt(i);
          set2.add(ch);
          cnt2[ch-'a']++;
        }

        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        return set1.equals(set2) && Arrays.equals(cnt1, cnt2);
    }
}