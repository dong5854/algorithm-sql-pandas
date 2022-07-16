"""
2438번
별 찍기 - 1

첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
https://www.acmicpc.net/problem/2438
"""
input = int(input())

for i in range(1, input+1):
  print("*" * i)