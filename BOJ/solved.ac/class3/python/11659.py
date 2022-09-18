"""
11659번
구간 합 구하기 4

https://www.acmicpc.net/problem/11659
"""
import sys

n, m = map(int, sys.stdin.readline().rstrip().split())

num_list = list(map(int, sys.stdin.readline().rstrip().split()))
sum_list = [0]


for i in range(len(num_list)):
    sum_list.append(num_list[i] + sum_list[i])

for _ in range(m):
    s,e = map(int, sys.stdin.readline().rstrip().split())
    print(sum_list[e] - sum_list[s-1])