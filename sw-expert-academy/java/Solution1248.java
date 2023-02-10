// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15PTkqAPYCFAYD
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
class Solution1248
{
    static Integer subTreeSize = 1;

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            subTreeSize = 1;
            final int V = sc.nextInt(), E = sc.nextInt(), ONE = sc.nextInt(), TWO = sc.nextInt();
            sc.nextLine();
            int[][] tree = new int[V + 1][4]; // 자식1, 자식2, 부모, 깊이
            int[] temp = Arrays.stream(sc.nextLine().split(" ")).
                    mapToInt(Integer::parseInt).toArray();
            for(int i = 0; i < temp.length; i += 2) {
                int p = temp[i], c = temp[i+1];
                if (tree[p][0] == 0) tree[p][0] = c;
                else tree[p][1] = c;
                tree[c][2] = p;
            }
            // 깊이 구하기
            boolean[] visited = new boolean[V + 1];
            bfs(1, tree, 1, visited);
            int commonAncestor =  lca(ONE, TWO, tree);

            findSubTreeSize(commonAncestor, tree);

            System.out.printf("#%d %d %d\n", test_case, commonAncestor, subTreeSize);
        }
    }

    public static void bfs(int r, int[][] tree, int depth, boolean[] visited) {
        visited[r] = true;
        tree[r][3] = depth;
        for(int i = 0; i < 2; i++) {
            if (tree[r][i] == 0) continue;
            if (visited[tree[r][i]]) continue;
            bfs(tree[r][i], tree, depth + 1, visited);
        }
    }
    public static int lca(int one, int two, int[][] tree) {
        // 깊이 먼저 맞추기
        while(tree[one][3] != tree[two][3]) {
            if (tree[one][3] > tree[two][3]) one = tree[one][2];
            else two = tree[two][2];
        }
        // 공통 부모 노드 찾기
        while (one != two) {
            one = tree[one][2];
            two = tree[two][2];
        }

        return one;
    }

    public static void findSubTreeSize(int r, int[][] tree) {
        for(int i = 0; i < 2; i++) {
            if (tree[r][i] != 0) {
                subTreeSize++;
                findSubTreeSize(tree[r][i], tree);
            }
        }
    }
}