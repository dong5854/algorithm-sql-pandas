"""
1620번
나는야 포켓몬 마스터 이다솜

https://www.acmicpc.net/problem/1620
"""
import sys

N, M = map(int, sys.stdin.readline().rstrip().split())

pokedex = []
pokedex_dic = {}
for i in range(N):
    pokemon = sys.stdin.readline().rstrip()
    pokedex.append(pokemon)
    pokedex_dic[pokemon] = i + 1
    

for _ in range(M):
    q = sys.stdin.readline().rstrip()
    if q.isnumeric():
        print(pokedex[int(q)-1])
    else:
        print(pokedex_dic[q])
