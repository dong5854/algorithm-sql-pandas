import java.util.*;

class Solution {

    List<Character> arr;
    int cnt;
    Character c;

    public int compress(char[] chars) {

        arr = new ArrayList<>();
        cnt = 0;
        c = chars[0];

        for (char ch : chars) {
            if (c != ch) {
                addChar(c);
            }
            c = ch;
            cnt++;
        }
        addChar(c);
        for (int i = 0; i < arr.size(); i++) {
            chars[i] = arr.get(i);
        }
        return arr.size();
    }

    public void addChar(char ac) {
        if (cnt <= 1) {
            arr.add(ac);
            cnt = 0;
            return;
        }
        arr.add(ac);
        String strInt = Integer.toString(cnt);
        for (int i = 0; i < strInt.length(); i++) {
            arr.add(strInt.charAt(i));
        }
        cnt = 0;
    }
}