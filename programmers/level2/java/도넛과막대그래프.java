import java.util.*;

public class 도넛과막대그래프 {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, List<Integer>> reverseGraph = new HashMap<>();
    int createdNode = -1;
    int donut = 0;
    int stick = 0;
    int eight = 0;

    public int[] solution(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            reverseGraph.putIfAbsent(edges[i][0], new ArrayList<>());
            reverseGraph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            reverseGraph.get(edges[i][1]).add(edges[i][0]);
        }

        for (int key : graph.keySet()) {
            if (graph.get(key).size() > 1 && reverseGraph.get(key).isEmpty()) {
                createdNode = key;
            }
        }

        for (int node : graph.get(createdNode)) {
            solve(node, node, 0);
        }

        return new int[]{createdNode, donut, stick, eight};
    }

    public void solve(int startNode, int node, int cnt) {
        while (true) {
            if (graph.get(node).size() > 1) {
                eight++;
                return;
            } else if (graph.get(node).isEmpty()) {
                stick++;
                return;
            } else if (cnt > 0 && node == startNode) {
                donut++;
                return;
            }
            node = graph.get(node).get(0);
            cnt += 1;
        }
    }

    public static void main(String[] args) {
//        도넛과막대그래프 solution = new 도넛과막대그래프();
//        System.out.println(Arrays.toString(solution.solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}})));


//        도넛과막대그래프 solution = new 도넛과막대그래프();
//        System.out.println(Arrays.toString(solution.solution(new int[][]
//                {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}}
//                )));

//        도넛과막대그래프 solution = new 도넛과막대그래프();
//        System.out.println(Arrays.toString(solution.solution(new int[][]
//                {{2, 1}, {2, 5}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 3}, {3, 8}, {8, 9}, {9, 10}, {10, 11}, {11, 3}}
//        )));

//        도넛과막대그래프 solution = new 도넛과막대그래프();
//        System.out.println(Arrays.toString(solution.solution(new int[][]
//                {{1, 12}, {8, 3}, {12, 7}, {7, 11}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}, {4, 11}, {4, 8}}
//        )));

//        도넛과막대그래프 solution = new 도넛과막대그래프();
//        System.out.println(Arrays.toString(solution.solution(new int[][]
//                {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}}
//        )));

        도넛과막대그래프 solution = new 도넛과막대그래프();
        System.out.println(Arrays.toString(solution.solution(new int[][]
                {{2, 1}, {1, 3}, {2, 4}, {4, 5}, {2, 6}, {6, 7}}
        )));
    }
}

//import java.util.*;
//
//class Solution {
//
//    Map<Integer, List<Integer>> graph; // 그래프
//    Map<Integer, Integer> in; // 들어오는 노드
//    Set<Integer> eightNodes; // 8자 그래프의 중심 노드
//    boolean[] visited;
//
//    public int[] solution(int[][] edges) {
//        graph = new HashMap<>();
//        in = new HashMap<>();
//        eightNodes = new HashSet<>();
//        visited = new boolean[1_000_001];
//        int[] answer = new int[4];
//
//        setGraph(edges);
//
//        // 추가된 노드 확인
//        int out = -1;
//        int addedNode = -1;
//        for (Integer node: in.keySet()) {
//            if (in.get(node).equals(0)) {
//                if (out < graph.get(node).size()) {
//                    out = graph.get(node).size();
//                    addedNode = node;
//                }
//            }
//            eightNodes.remove(addedNode);
//            answer[0] = addedNode;
//        }
//
//        // 8 자 그래프 개수
//        answer[3] = eightNodes.size();
//        for (int node : eightNodes) {
//            checkEightVisited(node);
//        }
//
//        // 도넛 그래프
//        for (int node : graph.keySet()) {
//            if (visited[node]) continue;
//            if (answer[0] == node) continue;
//            int type = getType(node, node, true);
//            if (type == 1) {
//                answer[1]++;
//            } else if (type == 2) {
//                answer[2]++;
//            }
//        }
//
//        return answer;
//    }
//
//    // true 면 도넛, 아니면 일자
//    public int getType(int node, int start, boolean isStart) {
//        if (!isStart && node == start) return 1;
//        if (visited[node]) return 0;
//        visited[node] = true;
//        if (graph.get(node).size() == 0) return 2;
//        int ret = 0;
//        for (int next : graph.get(node)) {
//            ret = getType(next, start, false);
//        }
//        return ret;
//    }
//
//    public void checkEightVisited(int node) {
//        if (visited[node]) return;
//        visited[node] = true;
//        for (int next : graph.get(node)) {
//            checkEightVisited(next);
//        }
//    }
//
//
//    public void setGraph(int[][] edges) {
//        for (int[] edge: edges) {
//            int from = edge[0];
//            int to = edge[1];
//            if (!graph.containsKey(from)) {
//                graph.put(from, new ArrayList<>());
//                in.put(from, 0);
//            }
//            if (!graph.containsKey(to)) {
//                graph.put(to, new ArrayList<>());
//                in.put(to, 0);
//            }
//
//            graph.get(from).add(to);
//            in.put(to, in.get(to) + 1);
//            if (graph.get(from).size() > 1) {
//                eightNodes.add(from);
//            }
//        }
//    }
//}