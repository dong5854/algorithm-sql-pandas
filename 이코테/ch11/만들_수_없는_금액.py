import sys

N = sys.stdin.readline().rstrip()

money_list = list(map(int, sys.stdin.readline().rstrip().split()))

money_list.sort()

target = 1
for m in money_list:
    if m > target:
        break
    target += m

print(target)
"""
내 풀이

money_list.sort(reverse=True)

cur = 1

while True:
    temp = cur
    for i in money_list:
        if temp >= i:
            temp -= i
    if temp != 0:
        print(cur)
        exit()
    cur += 1
"""