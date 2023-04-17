import java.io.*;
import java.util.*;

class Result {

  public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    List<Integer> ans = new ArrayList<>();
    List<Integer> removeDupl = new ArrayList<>();
    for (Integer r : ranked) {
      if (removeDupl.size() == 0) {
        removeDupl.add(r);
        continue;
      }
      if (!removeDupl.get(removeDupl.size() - 1).equals(r)) {
        removeDupl.add(r);
      }
    }
    System.out.println(removeDupl);
    for (Integer p : player) {
      int result = Collections.binarySearch(removeDupl, p, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          return -Integer.compare(o1, o2);
        }
      });
      if (result >= 0) {
        ans.add(result + 1);
      } else {
        result = ~result;
        ans.add(result + 1);
      }
    }

    return ans;
  }

}
