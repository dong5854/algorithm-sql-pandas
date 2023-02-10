// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD
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
class Solution1249
{

    final static int[] dRow = new int[]{0,0,1,-1};
    final static int[] dCol = new int[]{1,-1,0,0};

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
            int size = sc.nextInt();
            sc.nextLine();
            int[][] graph = new int[size][];
            int[][] counter = new int[size][size];
            boolean[][] visited = new boolean[size][size];

            for(int i = 0; i < size; i++) {
                graph[i] = sc.nextLine().chars().map(Character::getNumericValue).toArray();
            }

            bfs(0,0,graph, counter, visited);
            System.out.printf("#%d %d\n", test_case, counter[size-1][size-1]);
        }
    }

    public static void bfs(int startRow, int startCol, int[][] graph, int[][] counter, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startRow][startCol] = true;
        counter[startRow][startCol] = 0;
        queue.add(new int[]{startRow, startCol});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0], curCol = cur[1];
            for (int i = 0; i < 4; i++) {
                int nRow = curRow + dRow[i], nCol = curCol + dCol[i];
                if (nRow >= graph.length || nCol >= graph.length || nRow < 0 || nCol < 0) continue;
                if (!visited[nRow][nCol] || counter[nRow][nCol] > counter[curRow][curCol] + graph[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    counter[nRow][nCol] = counter[curRow][curCol] + graph[nRow][nCol];
                    queue.add(new int[]{nRow, nCol});
                }
            }
        }
    }
}