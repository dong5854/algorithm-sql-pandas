import sys

N = int(sys.stdin.readline().rstrip())

adventurers = list(map(int, sys.stdin.readline().rstrip().split()))

adventurers.sort()

groups = 0
people = 0

for a in adventurers:
    # 모험가 추가
    people += 1
    if people >= a:
        groups += 1
        people = 0

print(groups)