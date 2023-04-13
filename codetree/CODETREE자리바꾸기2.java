import java.io.*;
import java.util.*;

public class CODETREE자리바꾸기2 {

  static Set<Integer>[] possibleSeats;
  static int[] seats;
  static int[][] command;
  static int N, K;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    possibleSeats = new HashSet[N + 1];
    seats = new int[N + 1];
    command = new int[K][2];
    for (int i = 1; i <= N; i++) {
      possibleSeats[i] = new HashSet<>();
      possibleSeats[i].add(i);
      seats[i] = i;
    }

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int seatA = Integer.parseInt(st.nextToken());
      int seatB = Integer.parseInt(st.nextToken());
      command[i][0] = seatA;
      command[i][1] = seatB;
    }

    for (int i = 0; i < 3; i++) {
      for (int k = 0; k < K; k++) {
        int seatAPerson = seats[command[k][0]];
        int seatBPerson = seats[command[k][1]];

        possibleSeats[seatAPerson].add(command[k][1]);
        possibleSeats[seatBPerson].add(command[k][0]);

        seats[command[k][0]] = seatBPerson;
        seats[command[k][1]] = seatAPerson;
      }
    }

    for (int i = 1; i <= N; i++) {
      System.out.println(possibleSeats[i].size());
    }
    br.close();
  }
}