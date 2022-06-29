/*
2754번
학점계산

어떤 사람의 C언어 성적이 주어졌을 때, 평점은 몇 점인지 출력하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/2754
 */
import java.io.*;

class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char first = (char)br.read();

    float score = 0;

    if(first == 'F'){
      System.out.println(0.0);
    } else{
      char second = (char)br.read();
      
      if(first == 'A') score += 4;
      else if(first == 'B') score += 3;
      else if(first == 'C') score += 2;
      else if(first == 'D') score += 1;

      if(second == '+') score += 0.3;
      else if(second == '-') score -= 0.3;

      System.out.println(score);
    }
  }
}