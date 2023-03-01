import java.util.*;
/**
 * 순열의 기본적인 코드
 */
class Permutation {

    static final char[] candidates = {'a', 'b', 'c', 'd', 'e'};
    static boolean[] visited = new boolean[candidates.length];
    static char[] result;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if (N > candidates.length) {
            System.out.println("candidates 의 길이보다 짧아야 한다.");
        }

        result = new char[N];

        perm(0);
    }

    static void perm(int cnt) {
        if (cnt == N) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            result[cnt] = candidates[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}