/*
10807번
개수 세기

총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/10807
*/
import java.io.*;
import java.util.*;

class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int amount = Integer.parseInt(br.readLine());
    int lists[] = Arrays
      .stream(br.readLine().split(" "))
      .mapToInt(Integer::parseInt)
      .toArray();
    int target = Integer.parseInt(br.readLine());

    int sum = 0;

    for(int i : lists){
      if(i == target) sum++;
    }

    bw.write(String.valueOf(sum));
    bw.flush();
  }
}