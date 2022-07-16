/*
2738번
행렬 덧셈

N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/2738
 */
import java.io.*;
import java.util.*;

class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int size[] = Arrays.stream(bf.readLine().split(" "))
      .mapToInt(Integer::parseInt)
      .toArray();

    int x = size[0];
    int y = size[1];

    int[][] first = new int[x][y];
    int[][] second= new int[x][y];
    int[][] result= new int[x][y];

    for(int i = 0; i < x; i++){
      first[i] = Arrays.stream(bf.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    }

    for(int i = 0; i < x; i++){
      second[i] = Arrays.stream(bf.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    }

    for(int i = 0; i < x; i++){
      for(int j = 0; j < y; j++){
        System.out.print(first[i][j] + second[i][j]);
        System.out.print(" ");
      }
        System.out.println("");
    }
  }
}