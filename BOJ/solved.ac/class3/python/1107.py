"""
1107번
리모컨

https://www.acmicpc.net/problem/1107
"""
import sys

n = int(sys.stdin.readline().rstrip())
m = int(sys.stdin.readline().rstrip())

if m != 0:
    disabled = set(map(int, sys.stdin.readline().rstrip().split()))
else:
    disabled = set()

candidate = []
btn_set = {i for i in range(0, 10)}

def find(num):
    for b in btn_set:
        temp = num + str(b)
        candidate.append(len(temp) + abs(n-int(temp)))

        if len(temp) < 6:
            find(temp)

# 고장난 버튼 빼기
btn_set -= disabled

# 단순히 + 혹은 - 만 누른 경우
candidate.append(abs(n-100))

# 자리수 구하기
lenght = len(str(n))
find('')

print(min(candidate))
