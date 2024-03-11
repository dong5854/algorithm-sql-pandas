import java.util.*;

class 조이스틱 {
    
    final int[] dx = {1,-1};
    int[] alphaCnt;
    
    class Node {
        char[] name;
        int idx, cnt;
        public Node(char[] Name, int idx,int cnt) {
            this.name = copy(Name);
            this.idx = idx;
            this.cnt = cnt;
        }
        
        public char[] getName() {
            return copy(this.name);
        }
        
        private char[] copy(char[] original) {
            char[] copied = new char[original.length];
            for (int i = 0; i < original.length; i++) {
                copied[i] = original[i];
            }
            return copied;
        }
    }
    
    public int solution(String name) {
        alphaCnt = new int[name.length()];
        for (int i = 0; i < name.length(); i++) {
            alphaCnt[i] = movetoCreate(name.charAt(i));
        }
        return bfs(name);
    }
    
    int bfs(String name) {
        int len  = name.length();
        char[] tempName = new char[len];
        Arrays.fill(tempName, 'A');
        tempName[0] = name.charAt(0);
        int cnt = alphaCnt[0];
        if (new String(tempName).equals(name)) {  // name 길이가 1인 경우
            return cnt;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(tempName,0,cnt));
        
        while(!queue.isEmpty()) {
            Node polled = queue.poll();
            if (new String(polled.name).equals(name)){
                return polled.cnt;
            }
            for (int i = 0; i < 2; i++) {
                int nIdx = (len + polled.idx + dx[i]) % len;
                char[] temp = polled.getName();
                if (temp[nIdx] != name.charAt(nIdx)) {
                    temp[nIdx] = name.charAt(nIdx);
                    queue.add(new Node(temp, nIdx, polled.cnt+alphaCnt[nIdx] + 1));
                    continue;
                }
                queue.add(new Node(temp, nIdx, polled.cnt + 1));
            }
        }
        return -1;
    }
    
    int movetoCreate(char alpha) {
        return Math.min(alpha - 'A', 'Z' - alpha + 1);
    }
}