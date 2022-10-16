"""
1043번
거짓말

https://www.acmicpc.net/problem/1043
"""
def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

# 부모 테이블, a, b, 진실을 아는 사람 리스트
def union_parent(parent, a, b, known):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a in known and b in known:
        return

    # 진실을 아는 사람과 같은 파티에 참여했을 경우
    if a in known: # a가 진실을 아는 경우, b를 같은 그룹에 넣는다.
        parent[b] = a
    elif b in known: # 반대로, b가 진실을 아는 경우, a를 같은 그룹에 넣는다.
        parent[a] = b
    else:
        # 둘 다 진실을 모를 경우 같은 그룹에 넣는다.
        if a < b:
            parent[b] = a
        else:
            parent[a] = b

import sys

# 사람의 수 N과 파티의 수 M
N, M = map(int, sys.stdin.readline().split())

# 부모 테이블 생성, 초기화
parent = list(range(N+1))

# 이야기의 진실을 아는 사람들 리스트
known = list(map(int, sys.stdin.readline().split()))[1:]

# 파티들
parties = []

# 파티 순회
for _ in range(M):
    party_info = list(map(int, sys.stdin.readline().split()))
    party_people_len = party_info[0]
    party_people = party_info[1:]
    for i in range(party_people_len - 1):
        union_parent(parent, party_people[i], party_people[i+1], known)

    parties.append(party_people)


ans = 0
# 지금까지 있었던 파티들 순회
for party in parties:
    # 해당 파티에서 진실을 아는 사람이 있었다면 해당 파티에서는 거짓말을 하지 않음
    for person in party:
        if find_parent(parent, person) in known:
            break
    else:
        ans += 1

print(ans)