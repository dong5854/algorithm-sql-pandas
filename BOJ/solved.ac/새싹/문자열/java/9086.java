/*
9086번
문자열

문자열을 입력으로 주면 문자열의 첫 글자와 마지막 글자를 출력하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/9086
 */
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        for(int i=0; i < number; i++){
            String input = br.readLine();
            System.out.println(input.charAt(0) + "" + input.charAt(input.length()-1));
        }
    }
}