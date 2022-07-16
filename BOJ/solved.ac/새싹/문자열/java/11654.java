/*
11654번
아스키 코드

알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/11654
 */
import java.util.*;

class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    String input = sc.next();

    char character = input.charAt(0);

    System.out.println((int) character);

    sc.close();
  }
}
/*
System.in.read()를 사용하면 더 짧게 가능합니다.

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int ch = System.in.read();
		System.out.println(ch);
	}
}
*/