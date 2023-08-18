import java.io.*;

class BOJ27866 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int idx = Integer.parseInt(br.readLine());
    System.out.println(input.charAt(idx-1));
    br.close();
  }
}