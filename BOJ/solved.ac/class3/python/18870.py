"""
18870번
좌표 압축

https://www.acmicpc.net/problem/18870
"""
import sys

n = int(sys.stdin.readline().rstrip())

coords = list(map(int, sys.stdin.readline().rstrip().split()))

sorted_coords = sorted(set(coords))

coords_dict = {data: i for i, data in enumerate(sorted_coords)}

for i in coords:
    print(coords_dict[i], end=' ')

