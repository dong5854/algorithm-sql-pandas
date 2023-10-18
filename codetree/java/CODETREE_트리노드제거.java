import java.util.*;
import java.io.*;

public class CODETREE_트리노드제거 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[n];
        int rootNode = -1;
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) rootNode = i;
            else tree[parent].add(i);
        }
        int cutNode = Integer.parseInt(br.readLine());
        if (rootNode == cutNode) {
            System.out.println(0);
            return;
        }

        visited[cutNode] = true;

        int cnt = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(rootNode);
        while(!q.isEmpty()) {
            int curNode = q.poll();
            if (visited[curNode]) continue;
            visited[curNode] = true;
            if (tree[curNode].isEmpty()) cnt++;
            if (tree[curNode].size() == 1 && tree[curNode].get(0).equals(cutNode)) cnt++;
            for (int nextNode : tree[curNode]) {
                q.add(nextNode);
            }
        }
        
        System.out.println(cnt);

        br.close();
    }
}