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
