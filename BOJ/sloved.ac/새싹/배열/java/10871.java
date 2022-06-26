/*
10871번
X보다 작은 수

정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/10871
*/
import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int input[] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int list[] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    for(int num: list){
      if(input[1] > num){
        bw.write(num + " ");
      }
    }

    bw.flush();
  }
}