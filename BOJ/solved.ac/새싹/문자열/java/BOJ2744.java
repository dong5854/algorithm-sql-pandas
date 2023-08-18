/*
2744번
대소문자 바꾸기

영어 소문자와 대문자로 이루어진 단어를 입력받은 뒤, 대문자는 소문자로, 소문자는 대문자로 바꾸어 출력하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/2744
*/
import java.io.*;

class BOJ2744 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    for(int i=0; i < input.length(); i++){
      String letter = Character.toString(input.charAt(i));
      if((int)input.charAt(i)>=97){
        System.out.print(letter.toUpperCase());
      } else{
        System.out.print(letter.toLowerCase());
      }
    }
  }
}