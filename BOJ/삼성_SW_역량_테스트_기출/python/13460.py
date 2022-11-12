"""
13460번
구슬 탈출 2

https://www.acmicpc.net/problem/13460
"""
from collections import deque

# 아래, 위, 좌, 우
d_col = [0, 0, -1, 1]
d_row = [-1, 1, 0, 0]


def bfs(maze, red_sr, red_sc, blue_sr, blue_sc):
    # 방문 기록은 4차원 배열을 헷갈리니까 dictionary로 구현
    visited = {}
    visited[(red_sr, red_sc, blue_sr, blue_sc)] = True

    q = deque()
    # 빨간 구슬 row, 발간 구글 col, 파란구슬 row, 파란 구슬 col
    q.append((red_sr, red_sc, blue_sr, blue_sc, 0))

    # 구슬을 돌려본다.
    while q:
        rr, rc, br, bc, c_cnt = q.popleft()

        # 이미 10번 움직였으면 다음에 움직이면 11번 이므로 -1 출력
        if c_cnt >= 10:
            return -1
        
        for i in range(4):
            red_in_hole = False
            blue_in_hole = False

            red_moved = 0
            blue_moved = 0

            n_rr = rr
            n_rc = rc
            n_br = br
            n_bc = bc

            # 빨간 공 처리
            while (maze[n_rr + d_row[i]][n_rc + d_col[i]] != '#'):
                n_rr += d_row[i]
                n_rc += d_col[i]
                red_moved += 1
                
                if maze[n_rr][n_rc] == 'O':
                    red_in_hole = True
                    break
            
            # 파란 공처리
            while(maze[n_br + d_row[i]][n_bc + d_col[i]] != '#'):
                n_br += d_row[i]
                n_bc += d_col[i]
                blue_moved += 1

                if maze[n_br][n_bc] == 'O':
                    blue_in_hole = True
                    break

            # 파란 공이 구멍에 들어가면 스킵
            if blue_in_hole:
                continue

            # 빨간 공만 구멍에 들어간 경우, 현재 횟수에서 1을 추가한 후 반환
            if red_in_hole:
                return c_cnt + 1

            # 빨간 구슬과 파란 구슬이 겹칠 경우, 더 많이 움직인 구슬을 한칸 뒤로 보냄
            if n_rr == n_br and n_rc == n_bc:
                if red_moved > blue_moved:
                    n_rr -= d_row[i]
                    n_rc -= d_col[i]
                else:
                    n_br -= d_row[i]
                    n_bc -= d_col[i]

            # 이미 방문한 경우
            if (n_rr, n_rc, n_br, n_bc) in visited:
                continue
            
            visited[(n_rr, n_rc, n_br, n_bc)] = True
            q.append((n_rr, n_rc, n_br, n_bc, c_cnt+1))
            
    return -1
            

            
        



row, col = map(int, input().split())

maze = []


# 미로 생성
for _ in range(row):
    info = input()
    maze.append(list(info))

red_sr, red_sc = 0, 0
blue_sr, blue_sc = 0, 0
# 빨간공과 파란공 위치
for r in range(row):
    for c in range(col):
        if maze[r][c] == 'B':
            blue_sr, blue_sc = r, c
        if maze[r][c] == 'R':
            red_sr, red_sc = r, c

# print(red_sr, red_sc)
# print(blue_sr, blue_sc)

print(bfs(maze, red_sr, red_sc, blue_sr, blue_sc))
