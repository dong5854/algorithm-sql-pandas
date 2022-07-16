"""
2798번
블랙잭

https://www.acmicpc.net/problem/2798
"""
a, b = map(int, input().split())
cards = list(map(int, input().split()))
result = 0

for i in cards:
  for j in cards:
    for p in cards:
      if b-(i + j + p) < b-result and b-(i + j + p) >= 0:
        if(len({i, j ,p}) == 3):
          result = i + j + p
        

print(result)
"""
백준에 있던 다른 풀이
def P(n,m,c):
	t=set()
	for i in range(n-2):
		for o in range(i+1,n-1):
			for p in range(o+1,n):
				s=c[i]+c[o]+c[p]
				if s<=m:
					t.add(s)
					break

	return max([*t])
print(P(*map(int,input().split()),list(sorted(map(int,input().split()))[::-1])))
"""
