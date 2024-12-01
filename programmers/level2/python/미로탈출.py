from collections import deque

DR = [-1,0,1,0]
DC = [0,-1,0,1]

def solution(maps):
    start_row = -1
    start_col = -1
    for i in range(len(maps)):
        for j in range(len(maps[i])):
            if maps[i][j] == 'S':
                start_row, start_col = i, j 
    
    lever_row, lever_col, lever_time = bfs(maps, start_row, start_col, 'L')
    if lever_time == -1:
        return lever_time
    
    _, _, end_time = bfs(maps, lever_row, lever_col, 'E')
    if end_time == -1:
        return end_time
    
    return lever_time + end_time

def bfs(maps, r, c, target):
    visited =[[False] * len(maps[0]) for i in range(len(maps))]
    visited[r][c] = True
    queue = deque([(r,c, 0)])
    
    while len(queue) > 0 :
        cur_row, cur_col, cur_time = queue.popleft()
        for i in range(4):
            next_row  = cur_row + DR[i]
            next_col  = cur_col + DC[i]
            next_time = cur_time + 1 
            if next_row < 0 or next_col < 0 or next_row >= len(maps) or next_col >= len(maps[0]):
                continue
            if maps[next_row][next_col] == 'X':
                continue
            if visited[next_row][next_col]:
                continue
                
            if maps[next_row][next_col] == target:
                return (next_row, next_col, next_time)
            
            visited[next_row][next_col] = True
            queue.append((next_row, next_col, next_time))

    return (-1,-1,-1)