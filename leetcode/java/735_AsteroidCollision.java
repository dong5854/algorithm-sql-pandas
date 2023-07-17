import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int a : asteroids) {
          if (stack.isEmpty() || (stack.peek() * a) > 0) {
            stack.push(a);
            continue;
        }

        boolean aExploded = false;
            while (!stack.isEmpty() && Math.abs(stack.peek()) < Math.abs(a) && a < 0 && ((stack.peek() * a) < 0)) {
                if (aExploded) break;
                stack.pop();
            }

            while (!stack.isEmpty() && Math.abs(stack.peek()) == Math.abs(a) && a < 0 && ((stack.peek() * a) < 0)) {
                if (aExploded) break;
                stack.pop();
                aExploded = true;
            }

            if (!stack.isEmpty() && Math.abs(stack.peek()) > Math.abs(a) && a < 0 && ((stack.peek() * a) < 0)) {
            aExploded = true;
            }

            if (!aExploded) {
                stack.push(a);
            }
        }

        int[] ans = new int[stack.size()];

        int idx = stack.size() - 1;
        while(!stack.isEmpty()) {
            ans[idx--] = stack.pop();
        }

        return ans;
    }
}