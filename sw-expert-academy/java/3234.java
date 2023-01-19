// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWAe7XSKfUUDFAUw
/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;
// double b = 1.0;
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{

    static int[] pow = new int[10]; // 2의 거듭 제곱
    static int[] fac = new int[10]; // factorial
    static int totalWeight = 0;
    static int ans = 0;
    static int N = 0;
    static int[] weights;
    static boolean[] visited;

    static void init() {
        pow[0] = 1;
        fac[0] = 1;
        for (int i = 1; i <= 9; i++) {
            pow[i] = pow[i-1] * 2;
            fac[i] = fac[i-1] * i;
        }
    }

    public static void main(String args[]) throws Exception
    {
        init();
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            sc.nextLine();
            weights = new int[N];
            visited = new boolean[N];
            totalWeight = 0;
            ans = 0;

            weights = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < N; i++) {
                totalWeight += weights[i];
            }
            permutation(0,0,0, totalWeight);

            System.out.printf("#%d %d\n", test_case, ans);
        }
    }

    public static void permutation(int idx, int leftSum, int rightSum, int remain) {
        if (leftSum >= remain + rightSum) {
            ans += pow[N-idx] * fac[N-idx];
            return;
        }
        if (idx == N) {
            ans++;
            return;
        }
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            int thisWeight = weights[i];
            permutation(idx + 1, leftSum + thisWeight, rightSum, remain - thisWeight);
            if(rightSum + thisWeight <= leftSum) permutation(idx + 1, leftSum, rightSum + thisWeight, remain - thisWeight);
            visited[i] = false;
        }
    }
}