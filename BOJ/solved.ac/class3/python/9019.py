"""
9019번
DSLR

https://www.acmicpc.net/problem/9019
"""
from collections import deque
import sys

n = int(sys.stdin.readline().rstrip())

def d(x):
    num = x * 2
    if num > 9999:
        num = num % 10000
    return num
    
def s(x):
    if x == 0:
        num = 9999
    else:
        num = x - 1
    
    return num
    
def l(x):
    pre = x % 1000
    post = x // 1000
    num = pre*10 + post
    return num

def r(x):
    pre = x % 10
    post = x // 10
    num = pre*1000 + post
    return num

oper = ['D', 'S', 'L', 'R']

def bfs(input, target, visited):
    queue = deque()
    queue.append((input, ''))
    visited[input] = True
    while queue:
        num, process = queue.popleft()
        if num == target:
            return process

        for i in range(4):
            if i == 0:
                result_num = d(num)
            elif i == 1:
                result_num = s(num)
            elif i == 2:
                result_num = l(num)
            elif i == 3:
                result_num = r(num)

            if visited[result_num] == False:
                    visited[result_num] = True
                    queue.append((result_num, process + oper[i]))

for _ in range(n):
    visited = [False for _ in range(10000)]
    input, target = map(int, sys.stdin.readline().rstrip().split())
    print(bfs(input, target, visited))