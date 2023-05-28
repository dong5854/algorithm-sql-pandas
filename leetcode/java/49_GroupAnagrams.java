import java.util.*;

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {        

      Map<String, List<String>> ansMap = new HashMap<>();
      
      for (int i = 0; i < strs.length; i++) {
          char[] arr = (strs[i].toCharArray());
          Arrays.sort(arr);
          String sorted = new String(arr);
          if (ansMap.containsKey(sorted)) {
              ansMap.get(sorted).add(strs[i]);
              continue;
          }
          List<String> temp = new ArrayList<>();
          temp.add(strs[i]);
          ansMap.put(sorted, temp);
      }

      List<List<String>> ans = new ArrayList<>();
      for (String key : ansMap.keySet()) {
          ans.add(ansMap.get(key));
      }
      return ans;
  }
}