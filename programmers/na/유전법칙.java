import java.util.*;

class Solution {

    final static String RR = "RR";
    final static String Rr = "Rr";
    final static String rr = "rr";

    public List<String> solution(int[][] queries) {

        List<String> ans = new ArrayList<>();

        for (int[] q : queries) {
            ans.add(find(q[0], q[1]-1));
        }
        return ans;
    }

    String find(int gen, int loc) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (gen > 1) {
            gen -= 1;
            int mod = loc % 4;
            loc = loc / 4;
            stack.push(mod);
        }

        while(!stack.isEmpty()) {
            int mod = stack.pop();
            if (mod == 0) {
                return RR;
            } else if (mod == 3) {
                return rr;
            }
        }

        return Rr;
    }
}