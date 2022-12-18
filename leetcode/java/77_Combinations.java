// https://leetcode.com/problems/combinations/description/?envType=study-plan&id=algorithm-i
import java.util.*;
// // 처음 제출한 코드
// class Solution {    
//     public List<List<Integer>> combine(int n, int k) {
//         List <List<Integer>> ans = new ArrayList<>();

//         combination(ans, new ArrayList<>(), 1, n, k);

//         return ans;
//     }

//     public void combination(List <List<Integer>> ans, List<Integer> current, int place, int n, int k) {
//         if (current.size() == k) {
//             ans.add(current);
//             return;
//         }

//         if (place > n) return;

//         for (int i = place; i <= n; i++) {
//             List<Integer> copy = new ArrayList<>(current);
//             copy.add(i);
//             combination(ans, copy, i + 1, n, k);
//         }
//     }
// }
// 개선한 코드, 반복문의 반복 횟수를 줄였다.
class Solution {    
    public List<List<Integer>> combine(int n, int k) {
        List <List<Integer>> ans = new ArrayList<>();

        combination(ans, new ArrayList<>(), 1, n, k);

        return ans;
    }

    public void combination(List <List<Integer>> ans, List<Integer> current, int place, int n, int k) {
        if (k == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (place > n) return;

        for (int i = place; i <= n - k + 1; i++) {
            current.add(i);
            combination(ans, current, i + 1, n, k - 1);
            current.remove(current.size() - 1);
        }
    }
}