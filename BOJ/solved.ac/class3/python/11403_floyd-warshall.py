"""
11403번
경로 찾기
floyd-warshall를 사용한 풀이
https://www.acmicpc.net/problem/11403
"""
import sys

INF = 100

n = int(sys.stdin.readline().rstrip())

graph = [[INF] * (n) for _ in range(n)]

for i in range(n):
    line = list(map(int, sys.stdin.readline().rstrip().split()))
    for j in range(len(line)):
        val = line[j]
        if val != 0:
            graph[i][j] = line[j]

for k in range(n):
    for i in range(n):
        for j in range(n):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

for i in range(n):
    for j in range(n):
        if graph[i][j] == INF:
            print(0, end=' ')
        else:
            print(1, end=' ')
    print()
