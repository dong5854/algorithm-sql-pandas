import sys

n = int(sys.stdin.readline().rstrip())
map = {}
for i in range(n):
    key = sys.stdin.readline().rstrip()
    if key in map:
        map[key] += 1
    else:
        map[key] = 1

ans = 0

for key in map:
    ans = max(ans, map[key])

print(ans)