import java.util.*;

class Solution {
    
    static int size;
    static Map<String, List<String>> t;
    static Map<String, Integer> v;
    static String[] ans;
    
    public String[] solution(String[][] tickets) {
        size = tickets.length+1;
        ans = new String[size];
        t = new HashMap<>();
        v = new HashMap<>();
        
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            t.putIfAbsent(from, new ArrayList<>());            
            t.get(from).add(to);
            
            v.put(from + " " + to, v.getOrDefault(from + " " + to, 0) + 1);
        }
        
        for (String[] ticket : tickets) {
            String from = ticket[0];
            Collections.sort(t.get(from));
        }
        
        ans[0] = "ICN";
        for (String to : t.get("ICN")) {
            if (dfs("ICN", to, 1)) break;
        }
        
        return ans;
    }
    
    public boolean dfs(String from, String to, int cnt) {
        if (cnt == size - 1) {
            ans[size-1] = to;
            return true;
        }
        if (t.get(to) == null) return false;
        v.put(from + " " + to, v.get(from + " " + to) - 1);
        ans[cnt] = to;
        for (String nTo : t.get(to)) {
            if (v.get(to + " " + nTo) == 0) continue;
            if (dfs(to, nTo, cnt + 1)) return true;
        }
        v.put(from + " " + to, v.get(from + " " + to) + 1);
        
        return false;
    }
}