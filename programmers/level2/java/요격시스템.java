import java.util.*;

class 요격시스템 {

    public int solution(int[][] targets) {
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int c = Integer.compare(o1[0], o2[0]);
                if (c == 0) c = -Integer.compare(o1[1], o2[1]);
                return c;
            }
        });
        boolean[] destroyed = new boolean[targets.length];

        int cnt = 0;
        for (int i = 0; i < targets.length; i++) {
            int[] cur = targets[i];
            destroyed[i] = true;
            cnt++;
            for (int  j = i + 1; j <= targets.length; j++) {
                if (j == targets.length) {
                    i = j - 1;
                    break;
                }
                if (cur[1] > targets[j][0]) {
                    if (cur[1] > targets[j][1]) cur = targets[j];
                    destroyed[j] = true;
                    continue;
                }
                i = j - 1;
                break;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        요격시스템 sol = new 요격시스템();
        // 3
        System.out.println(
                sol.solution(new int[][]{
                        {4,5}, {4,8}, {10,14},
                        {11,13},{5,12},{3,7},{1,4}
                })
        );
    }
}