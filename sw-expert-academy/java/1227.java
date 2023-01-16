// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14wL9KAGkCFAYD
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
    static int[] dRow = new int[]{-1,1,0,0};// 위, 아래, 왼쪽, 오른쪽
    static int[] dCol = new int[]{0,0,-1,1};// 위, 아래, 왼쪽, 오른쪽

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            test_case = sc.nextInt();
            sc.nextLine();
            char[][] maze = new char[100][100];
            boolean[][] visited = new boolean[100][100];
            for(int i = 0; i < 100; i++) {
                maze[i] = sc.nextLine().toCharArray();
            }

            int startRow = 0, startCol = 0;
            startFinder:
            for (int r = 0; r < 100; r++) {
                for(int c = 0; c < 100; c++) {
                    if (maze[r][c] == '2') {
                        startRow = r;
                        startCol = c;
                        break startFinder;
                    }
                }
            }

            System.out.printf("#%d %d\n", test_case, bfs(maze, startRow, startCol, visited));
        }
    }

    public static int bfs(char[][] maze, int startRow, int startCol, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startRow][startCol] = true;
        queue.add(new int[]{startRow, startCol});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nRow = cur[0] + dRow[i];
                int nCol = cur[1] + dCol[i];
                if (nRow >= 100 || nCol >= 100 || nRow < 0|| nCol < 0) continue;
                if (visited[nRow][nCol]) continue;
                if (maze[nRow][nCol] == '3') return 1;
                if (maze[nRow][nCol] != '0') continue;
                visited[nRow][nCol] = true;
                queue.add(new int[]{nRow, nCol});
            }
        }
        return 0;
    }
}