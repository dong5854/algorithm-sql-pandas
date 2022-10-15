"""
섬 연결하기

https://school.programmers.co.kr/learn/courses/30/lessons/42861
"""
# 특정 원소가 속한 집합을 찾는다
def find_parent(parent, x):
    if parent[x] != x:
        # 루트 노드가 아니라면 루트 노드를 찾을 때까지 재귀적으로 호출
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

# 두 원소가 속한 집합을 합치기
def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def solution(n, costs):
    answer = 0
    parent = [0] * n # 부모 테이블 초기화
    
    # 부모 테이블 상에서, 부모를 자기 자신으로 초기화
    for i in range(n):
        parent[i] = i
    
    # 간선을 비용 순으로 정렬
    costs.sort(key= lambda x: x[2])
    
    # 간선을 하나씩 확인하며,
    for cost in costs:
        a, b, c = cost
        # 사이클이 발생하지 않는 경우에만 집합에 포함
        if find_parent(parent, a) != find_parent(parent, b):
            union_parent(parent, a, b)
            answer += c
    
    return answer