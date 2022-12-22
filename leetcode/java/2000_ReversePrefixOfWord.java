// https://leetcode.com/problems/reverse-prefix-of-word/description/
class Solution {
    public String reversePrefix(String word, char ch) {
        int left = 0;
        int right = 0;
        char[] wordChars = word.toCharArray();
        while (true) {
            if (right >= word.length()) return word;
            if (wordChars[right] == ch) break;
            right++;
        }
        while (left < right) {
            char temp = wordChars[right];
            wordChars[right] = wordChars[left];
            wordChars[left] = temp;
            left++;
            right--;
        }

        return String.valueOf(wordChars);
    }
}
// /*
//  * 최대한 짧게 줄인 코드
//  */
// public String reversePrefix(String word, char ch) {
// 	char chArr[]=word.toCharArray();int i=0,len=chArr.length;
// 	while(i<len && chArr[i]!=ch) i++;
// 	if(i>=len) return word;
// 	for(int j=0;j<i;j++,i--){
// 		char temp=chArr[j];
// 		chArr[j]=chArr[i];
// 		chArr[i]=temp;
// 	}
// 	return String.valueOf(chArr);
// }