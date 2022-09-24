"""
16928번
뱀과 사다리 게임

https://www.acmicpc.net/problem/16928
"""
from collections import deque
import sys

n, m = map(int, sys.stdin.readline().rstrip().split())

game_board = [0 for _ in range(101)]
visited = [False for _ in range(101)]


def bfs(start):
    global game_board, visited
    cnt = 0
    visited[start] = True
    dq = deque()
    dq.append((start, cnt))
    while dq:
        cur, counter = dq.popleft()

        if cur >= 100:
            return counter

        for i in range(1,7):
            if cur+i > 100:
                continue
            nxt_counter = counter + 1
            # 옆으로 이동
            if game_board[cur+i] != 0:
                nxt = game_board[cur+i]
            else:
                nxt = cur+i
            
            if visited[nxt] is False:
                visited[nxt] = True
                dq.append((nxt, nxt_counter))


for _ in range(n+m):
    s, e = map(int, sys.stdin.readline().rstrip().split())
    game_board[s] = e


print(bfs(1))