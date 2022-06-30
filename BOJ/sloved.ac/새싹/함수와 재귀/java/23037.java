/*
23037번
5의 수난

키파는 문득 3과 4의 견고한 벽에 가로막혀 스포트라이트를 받지 못하는 5를 떠올렸다. '세상에 얼마나 많은 것들이 5와 관련이 있는데!'

키파는 5가 쓰이는 곳을 떠올리기 시작했다. 사람의 손가락도 5개, 정다면체의 개수도 5개, 알려진 불가촉 홀수는 5뿐이고, 별은 보통 오각별, 그리고 무엇보다 "별이 다섯 개!"

그러자 문득 키파는 자신의 마음 속에서 다섯제곱을 하고 싶은 욕망이 올라오는 것을 느꼈다. 키파를 위해, 다섯 자리 수를 입력받아, 각 자릿수의 다섯제곱의 합을 출력하는 프로그램을 작성해 주자.
https://www.acmicpc.net/problem/23037
 */
import java.util.*;

class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] input = sc.next().split("");

    int sum = 0;

    for(String i: input){
      sum += Math.pow(Integer.parseInt(i),5);
    }

    System.out.println(sum);

    sc.close();
  }
}