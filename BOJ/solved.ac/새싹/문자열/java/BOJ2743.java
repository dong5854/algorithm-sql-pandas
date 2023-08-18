/*
2743번
단어 길이 재기

알파벳으로만 이루어진 단어를 입력받아, 그 길이를 출력하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/2743
 */
  import java.util.Scanner;

  class BOJ2743 {
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
  
      String input = sc.nextLine();
  
      System.out.println(input.length());

      sc.close();
    }
  }
/*
BufferedReader를 사용해서 시간 단축
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		String str = stk.nextToken();
		System.out.println(str.length());
	}
}
*/