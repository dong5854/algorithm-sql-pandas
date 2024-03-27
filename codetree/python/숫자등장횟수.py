import sys

input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
hashmap = dict()

ns = list(map(int, input().rstrip().split()))
for i in ns:
    if i not in hashmap:
        hashmap[i] = 1
    else:
        hashmap[i] += 1

ms = map(int, input().rstrip().split())
for i in ms:
    print(hashmap[i] if i in hashmap else 0, end=" ")