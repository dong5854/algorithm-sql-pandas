"""
5525번
IOIOI

https://www.acmicpc.net/problem/5525
"""
import sys

n = int(sys.stdin.readline().rstrip())

m = int(sys.stdin.readline().rstrip())

s = sys.stdin.readline().rstrip()

cnt, ans, i = 0, 0, 0
while i < m - 1:
    if s[i:i+3] == 'IOI':
        cnt += 1
        if cnt == n:
            cnt -= 1
            ans += 1
        i += 2
    else:
        i += 1
        cnt = 0

print(ans)