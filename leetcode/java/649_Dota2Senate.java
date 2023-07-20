import java.util.*;

class Solution {

    static final String Radiant = "Radiant";
    static final String Dire = "Dire";

    public String predictPartyVictory(String senate) {
        ArrayDeque<Character> queue = new ArrayDeque<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('D', 0);
        for(int i = 0; i < senate.length(); i++) {
            queue.offer(senate.charAt(i));
            map.put(senate.charAt(i), map.get(senate.charAt(i)) + 1);
        }


        int banRadiant = 0;
        int banDire = 0;
        while(queue.size() > 1 && map.get('D') != 0 && map.get('R') != 0) {
            char temp = queue.poll();
            if (temp == 'R' && banRadiant > 0) {
                banRadiant--;
                map.put(temp, map.get(temp) - 1);
            } else if (temp == 'D' && banDire > 0) {
                banDire--;
                map.put(temp, map.get(temp) - 1);
            } else if (temp == 'R') {
                banDire++;
                queue.offer(temp);
            } else if (temp == 'D') {
                banRadiant++;
                queue.offer(temp);
            }
        }

        char ans = queue.poll();
        if (ans == 'R') {
            return Radiant;
        }
        return Dire;
    }
}