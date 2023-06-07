class Solution {
    // 상, 우, 하, 좌
    final int[] dr = {1, 0, -1, 0};
    final int[] dc = {0, 1, 0, -1};

    public int[] solution(String command) {
        int dir = 0;
        int[] answer = {0, 0};
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == 'R') {
                dir = (dir + 1) % 4;
            } else if (c == 'L') {
                if (dir == 0) {
                    dir = 3;
                } else {
                    dir = (dir - 1);
                }
            } else if (c == 'G') {
                answer[1] += dr[dir];
                answer[0] += dc[dir];
            } else if (c == 'B') {
                answer[1] -= dr[dir];
                answer[0] -= dc[dir];
            }
        }
        return answer;
    }
}