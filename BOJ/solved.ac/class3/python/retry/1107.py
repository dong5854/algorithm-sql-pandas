"""
1107번
리모컨

https://www.acmicpc.net/problem/1107
"""
import sys

N = int(sys.stdin.readline().rstrip())
M = int(sys.stdin.readline().rstrip())

candidates = []
btn = {i for i in range(0,10)}
broken = {}

broken = set(map(int,sys.stdin.readline().rstrip().split()))

btn -= broken

def find(num: str):
    for b in btn:
        temp = num + str(b)
        candidates.append(len(temp) + abs(N-int(temp)))
        if len(temp) < 6:
            find(temp)

candidates.append(abs(N-100))
find('')

print(min(candidates))