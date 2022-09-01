"""
9375번
패션왕 신해빈

https://www.acmicpc.net/problem/9375
"""
import sys

t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    items = {}
    result = 1
    n = int(sys.stdin.readline().rstrip())
    for _ in range(n):
        item, categories = sys.stdin.readline().rstrip().split()
        if categories not in items:
            items[categories] = [item]
        else:
            items[categories].append(item)
    for key in items:
        result *= (len(items[key]) + 1)
    print(result - 1)