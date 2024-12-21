class Solution:
    def maxKDivisibleComponents(self, n: int, edges: List[List[int]], values: List[int], k: int) -> int:
        if n < 2:
            return 1
        
        # 그래프 구성
        component_count = 0
        graph = defaultdict(set)

        for node_a, node_b in edges:
            graph[node_a].add(node_b)
            graph[node_b].add(node_a)

        # 리프노드로 큐 초기화
        queue = deque(
            node for node, neighbors in graph.items() if len(neighbors) == 1
        )

        # bfs
        while queue:
            current_node = queue.popleft()
            neighbor_node = (
                 next(iter(graph[current_node])) if graph[current_node] else -1
            )

            if neighbor_node >= 0:
                graph[neighbor_node].remove(current_node)

            if values[current_node] % k == 0:
                component_count += 1
            else:
                values[neighbor_node] += values[current_node]

            if neighbor_node >= 0 and len(graph[neighbor_node]) == 1:
                queue.append(neighbor_node)
            
        return component_count
