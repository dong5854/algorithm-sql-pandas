// https://leetcode.com/problems/letter-case-permutation/description/?envType=study-plan&id=algorithm-i
import java.util.*;
// // 처음 제출한 코드
// class Solution {
//     public List<String> letterCasePermutation(String s) {
//         List<String> ans = new ArrayList<>();
//         StringBuilder stringBuilder = new StringBuilder();
//         backtracking(s, ans, stringBuilder, 0);
//         return ans;
//     }

//     public void backtracking(String s, List<String> ans, StringBuilder stringBuilder, int currentIdx) {
//         if (stringBuilder.length() == s.length()) {
//             ans.add(stringBuilder.toString());
//             return;
//         }

//         for (int i = currentIdx; i < s.length(); i++) {
//             // 숫자
//             if (Character.isDigit(s.charAt(i))) {
//                 stringBuilder.append(s.charAt(i));
//                 backtracking(s, ans, stringBuilder, i + 1);    
//                 stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//                 continue;
//             }

//             // 소문자
//             Character lowerChar = Character.toLowerCase(s.charAt(i));
//             stringBuilder.append(lowerChar);
//             backtracking(s, ans, stringBuilder, i + 1);
//             stringBuilder.deleteCharAt(stringBuilder.length() - 1);

//             // 대문자
//             Character upperChar = Character.toUpperCase(s.charAt(i));
//             stringBuilder.append(upperChar);
//             backtracking(s, ans, stringBuilder, i + 1);
//             stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//         }
//     }
// }
// 개선한 코드
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        backtracking(s.toCharArray(), ans, 0);
        return ans;
    }

    public void backtracking(char[] temp, List<String> ans, int currentIdx) {
        if (currentIdx == temp.length) {
            ans.add(new String(temp));
            return;
        }

        if (Character.isDigit(temp[currentIdx])) {
            backtracking(temp, ans, currentIdx + 1);
            return;
        }

        temp[currentIdx] = Character.toLowerCase(temp[currentIdx]);
        backtracking(temp, ans, currentIdx + 1);

        temp[currentIdx] = Character.toUpperCase(temp[currentIdx]);
        backtracking(temp, ans, currentIdx + 1);
    }
}
// // BFS 코드
// class Solution {
//     public List<String> letterCasePermutation(String s) {
//         if (s == null) return new LinkedList<>();

//         Queue<String> queue = new LinkedList<>();
//         queue.offer(s);
        
//         for (int i = 0; i < s.length(); i++) {
//             if (Character.isDigit(s.charAt(i))) continue;
//             int size = queue.size();
//             for (int j = 0; j < size; j++) {
//                 String current = queue.poll();
//                 char[] temp = current.toCharArray();

//                 temp[i] = Character.toUpperCase(temp[i]);
//                 queue.offer(new String(temp));


//                 temp[i] = Character.toLowerCase(temp[i]);
//                 queue.offer(new String(temp));
//             }
//         }

//         return new LinkedList<>(queue);
//     }
// }