import java.io.*;
import java.util.*;

public class BOJ1786 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] text = br.readLine().toCharArray();
    char[] pattern = br.readLine().toCharArray();

    int tLength = text.length;
    int pLength = pattern.length;

    // 부분일치 테이블 만들기
    int[] pi = new int[pLength];
    for (int i = 1, j = 0; i < pLength; i++) {
      while (j > 0 && pattern[i] != pattern[j])
        j = pi[j - 1];

      if (pattern[i] == pattern[j])
        pi[i] = ++j;
      else
        pi[i] = 0;
    }

    int cnt = 0;
    List<Integer> list = new ArrayList<>();
    // i : 텍스트 포인터, j: 패턴 포인터
    for (int i = 0, j = 0; i < tLength; i++) {
      while (j > 0 && text[i] != pattern[j])
        j = pi[j - 1];

      if (text[i] == pattern[j]) { // 두 글자 일치
        if (j == pLength - 1) { // j가 패턴의 마지막 인덱스면 일치하기 때문에
          cnt++; // 카운트 증가
          list.add(i - j); // 시작 인덱스
          j = pi[j];
        } else {
          j++;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(cnt).append("\n");
    for (Integer i : list) {
      sb.append(i + 1).append(" ");
    }
    System.out.println(sb);
  }
}
