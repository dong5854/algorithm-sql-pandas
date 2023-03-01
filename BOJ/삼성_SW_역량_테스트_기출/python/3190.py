"""
3190번
뱀

https://www.acmicpc.net/problem/3190
"""
import sys

N = int(sys.stdin.readline().rstrip())
K= int(sys.stdin.readline().rstrip())

game_map = [[0] * (N + 1) for _ in range(N + 1)]

print(game_map)