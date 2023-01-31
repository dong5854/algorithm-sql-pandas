// https://leetcode.com/problems/backspace-string-compare/
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        int sPointer = 0, tPointer = 0;
        while(sPointer < s.length() || tPointer < t.length()) {
            if(sPointer < s.length()){
                if(s.charAt(sPointer) == '#') ignoreEmptyPop(sStack);
                else sStack.push(s.charAt(sPointer));
                sPointer++;
            } 
            if(tPointer < t.length()) {
                if(t.charAt(tPointer) == '#') ignoreEmptyPop(tStack);
                else tStack.push(t.charAt(tPointer));
                tPointer++;
            }
        }
        if(sStack.equals(tStack)) return true;
        return false;
    }
    public void ignoreEmptyPop(Stack<Character> stack) {
        if(!stack.isEmpty()) stack.pop();
    }
}