import java.util.*;

class Solution {
  public int[][] merge(int[][] intervals) {

      Arrays.sort(intervals, new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
              return Integer.compare(o1[0], o2[0]);
          }
      });

      List<int[]> ans = new ArrayList<>();
      ans.add(intervals[0]);

      for (int i = 1; i < intervals.length; i++) {
          int curIdx = ans.size() - 1;
          if (ans.get(curIdx)[1] >= intervals[i][0] && ans.get(curIdx)[1] <= intervals[i][1]) {
              ans.get(curIdx)[1] = intervals[i][1];
          } else if(ans.get(curIdx)[0] <= intervals[i][0] && ans.get(curIdx)[1] >= intervals[i][1]) {
              continue;
          } else {
              ans.add(intervals[i]);
          }
      }

      int[][] answer = new int[ans.size()][];

      for (int i = 0; i < answer.length; i++) {
          answer[i] = ans.get(i);
      }

      return answer;
  }
}