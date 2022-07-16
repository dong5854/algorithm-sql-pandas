"""
2738번
행렬 덧셈

N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/2738
"""
import sys

x,y = map(int, sys.stdin.readline().rstrip().split())

a = []
b= []

for i in range(x):
    a.append(list(map(int, sys.stdin.readline().rstrip().split())))

for i in range(x):
    b.append(list(map(int, sys.stdin.readline().rstrip().split())))

result = [[0 for i in range(x)] for j in range(y)]

for i in range(x):
    for j in range(y):
        print(a[i][j] + b[i][j], end= " ")
    print("")