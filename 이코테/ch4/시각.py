# 내 풀이
N = int(input())
cnt = 0

for h in range(N + 1):
    for m in range(60):
        for s in range(60):
            if "3" in str(s) or "3" in str(m) or "3" in str(h):
                cnt += 1

print(cnt)
"""
# 책의 풀이
N = int(input())
cnt = 0

for h in range(N + 1):
    for m in range(60):
        for s in range(60):
            if "3" in str(s) + str(m) + str(h):
                cnt += 1

print(cnt)
"""