"""
10807번
개수 세기

총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/10807
"""
import sys

amount = int(sys.stdin.readline())
lists = list(map(int, sys.stdin.readline().rstrip().split()))
target = int(sys.stdin.readline())

result = 0

for i in lists:
    if i == target: result += 1

print(result)