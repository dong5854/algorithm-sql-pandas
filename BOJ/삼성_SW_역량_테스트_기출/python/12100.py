"""
12100번
2048 (Easy)

https://www.acmicpc.net/problem/12100
"""
from collections import deque

directions = ["UP", "DOWN", "LEFT", "RIGHT"]
# 반대로
d_row = [1, -1, 0, 0]
d_col = [0, 0, 1, -1]

q = deque()


def insert_queue(board: list, row: int, col: int):
    global q

    if board[row][col]:  # 0 이 아니면,
        q.append(board[row][col])  # 값을 받는다.
        board[row][col] = 0  # 처리된 보드는 0


def merge(board: list, row: int, col: int, dr: int, dc: int):
    global q
    while q:
        b = q.popleft()
        if not board[row][col]:  # 보드가 비어있으면,
            board[row][col] = b
        elif board[row][col] == b:  # 값이 일치하면,
            board[row][col] = b * 2
            row += dr
            col += dc
        else:  # 값이 일치하지 않으면
            row += dr
            col += dc
            board[row][col] = b


def move(board: list, direction: str):
    global N
    if direction == "UP":
        for col in range(N):
            for row in range(N):
                insert_queue(board, row, col)
            merge(board, 0, col, d_row[0], d_col[0])
    elif direction == "DOWN":
        for col in range(N):
            for row in range(N - 1, -1, -1):
                insert_queue(board, row, col)
            merge(board, N - 1, col, d_row[1], d_col[1])
    elif direction == "LEFT":
        for row in range(N):
            for col in range(N):
                insert_queue(board, row, col)
            merge(board, row, 0, d_row[2], d_col[2])
    elif direction == "RIGHT":
        for row in range(N):
            for col in range(N - 1, -1, -1):
                insert_queue(board, row, col)
            merge(board, row, N - 1, d_row[3], d_col[3])


def solution(board: list, N: int, cnt: int):
    global answer
    # 5번 이동 후, 가장 큰 블록 확인
    if cnt == 5:
        for b in board:
            answer = max(answer, max(b))
        return

    back_up_board = [x[:] for x in board]
    
    # 좌, 우, 위, 아래로 밀기
    for direction in directions:
        move(board, direction)
        solution(board, N, cnt + 1)
        board =[x[:] for x in back_up_board]


N = int(input())

answer = 0

board = []

for _ in range(N):
    board.append(list(map(int, input().split())))

solution(board, N, 0)

print(answer)
