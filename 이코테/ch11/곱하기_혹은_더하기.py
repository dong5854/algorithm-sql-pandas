import sys

n = list(map(int, sys.stdin.readline().rstrip()))

answer = n[0]
for i in range(1, len(n)):
    if answer * n[i] > answer + n[i]:
        answer *= n[i]
    else:
        answer += n[i]

print(answer)