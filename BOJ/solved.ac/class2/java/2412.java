/*
11050번
이항 계수 1

https://www.acmicpc.net/problem/11050
*/
import java.io.*;

  class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String input = br.readLine();
      int n = Integer.parseInt(input.split(" ")[0]);
      int k = Integer.parseInt(input.split(" ")[1]);
      System.out.println(factorial(n) / (factorial(k) * factorial(n-k)));
    } 

    static int factorial(int n){
      if (n==0){
       return 1;
      }
      return n * factorial(n-1);   
    }
  }