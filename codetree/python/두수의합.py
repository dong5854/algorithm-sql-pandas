from collections import defaultdict

n, k = map(int, input().split())
arr = list(map(int, input().split()))
mem = defaultdict(int)
ans = 0

for i in arr:
    if k-i in mem:
        ans += mem[k-i]
    mem[i] += 1
    
print(ans)