import java.util.*;

/**
 * 조합의 기본적인 코드
 */
class Combination {
    static final char[] candidates = {'a', 'b', 'c', 'd', 'e'};
    static char[] result;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if (N > candidates.length) {
            System.out.println("candidates 의 길이보다 짧아야 한다.");
        }

        result = new char[N];

        comb(0, 0);
    }

    static void comb(int cnt, int start) {
        if (cnt == N) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            result[cnt] = candidates[i];
            comb(cnt + 1, i + 1);
        }
    }
}