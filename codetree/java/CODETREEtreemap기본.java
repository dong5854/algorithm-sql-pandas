import java.io.*;
import java.util.*;

public class CODETREEtreemap기본 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n;i++) {
            String[] command = br.readLine().split(" ");
            switch(command[0]) {
                case "add":
                    map.put(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
                case "find":
                if (map.containsKey(Integer.parseInt(command[1])))
                    sb.append(map.get(Integer.parseInt(command[1]))).append("\n");
                else
                    sb.append("None").append("\n");
                break;
                case "remove":
                    map.remove(Integer.parseInt(command[1]));
                    break;
                case "print_list":
                    if (map.isEmpty()) {
                        sb.append("None\n");
                        break;
                    }
                    for (Integer key : map.keySet()) {
                        sb.append(map.get(key)).append(" ");
                    }
                    sb.append("\n");
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}