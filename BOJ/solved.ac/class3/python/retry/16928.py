"""
16928번
뱀과 사다리 게임

https://www.acmicpc.net/problem/16928
"""
import sys
from collections import deque

def bfs(game_board: list):
    visited[1] = True
    q = deque()
    # 현재횟수, 현재 칸
    q.append((0, 1))
    while q:
        cur_cnt, cur_place = q.popleft()
        nxt_cnt = cur_cnt + 1
        # 주사위는 1~6
        for i in range(1, 7):
            nxt_place = cur_place + i
            if nxt_place == 100:
                return nxt_cnt
            if nxt_place > 100:
                continue
            if nxt_place in game_board:
                nxt_place = game_board[nxt_place]
            if visited[nxt_place] == False:
                visited[nxt_place] = True
                q.append((nxt_cnt,nxt_place))
    return 0


N, M =map(int, sys.stdin.readline().rstrip().split())

game_board = {}
visited = [False for _ in range(101)]

for _ in range(N + M):
    f, t = map(int, sys.stdin.readline().rstrip().split())
    game_board[f] = t

print(bfs(game_board=game_board))