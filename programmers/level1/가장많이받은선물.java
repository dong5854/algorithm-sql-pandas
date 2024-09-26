import java.util.*;

class 가장많이받은선물 {

    int[][] table;
    Map<String, Integer> nameToId;
    Map<String, int[]> presentPoint; // value: [준 선물, 받은 선물]
    int id;

    public int getPresentPoint(String name) {
        int[] pp = presentPoint.get(name);
        return pp[0] - pp[1];
    }

    public int solution(String[] friends, String[] gifts) {

        table = new int[friends.length][friends.length];
        nameToId = new HashMap<>();
        presentPoint = new HashMap<>();
        id = 0;

        for (int i = 0; i < friends.length; i++) {
            nameToId.put(friends[i], id);
            presentPoint.put(friends[i], new int[2]);
            id++;
        }

        for (String gift: gifts) {
            String[] splited = gift.split(" ");
            String from = splited[0];
            String to = splited[1];
            int fromId = nameToId.get(from);
            int toId = nameToId.get(to);
            table[fromId][toId]++;

            int[] pp = presentPoint.get(from);
            pp[0]++;
            presentPoint.put(from, pp);

            pp = presentPoint.get(to);
            pp[1]++;
            presentPoint.put(to, pp);
        }

        int answer = 0;
        for (int t = 0; t < friends.length; t++) {
            int sum = 0;
            for (int f = 0; f < friends.length; f++) {
                if ((table[f][t] == 0 && table[t][f] == 0) || table[f][t] == table[t][f]) {
                    if (getPresentPoint(friends[t]) > getPresentPoint(friends[f])) {
                        sum++;
                    }
                } else if (table[t][f] > table[f][t]) {
                    sum++;
                }
            }
            answer = Math.max(answer, sum);
        }


        return answer;
    }
}

