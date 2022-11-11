"""
1439번
뒤집기

https://www.acmicpc.net/problem/1439
"""
import sys

num = sys.stdin.readline().rstrip()

zero_sections = 0
one_sections = 0

cur = num[0]
for i in range(1, len(num)):
    if num[i] == cur:
        continue
    else:
        if cur == '1':
            one_sections += 1
        elif cur == "0":
            zero_sections += 1
        cur = num[i]

# 마지막 섹션 처리
if cur == '1':
    one_sections += 1
elif cur == "0":
    zero_sections += 1

print(min(zero_sections, one_sections))