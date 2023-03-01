/**
 * 부분집합의 기본적인 코드
 */
class Subset {

    static final char[] candidates = {'a', 'b', 'c', 'd', 'e'};
    static boolean[] visited = new boolean[candidates.length];
    public static void main(String[] args) {
        subs(0);
    }

    static void subs(int cnt) {
        if (cnt == candidates.length) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) System.out.print(candidates[i] + " ");
            }
            System.out.println();
            return;
        }

        visited[cnt] = true;
        subs(cnt + 1);
        visited[cnt] = false;
        subs(cnt + 1);
    }
}