# 내 풀이
import sys


def turn_left():
    global character
    if character[2] == 0:
        character[2] = 3
    else:
        character[2] -= 1


# 맴 사이즈
map_size = list(map(int, sys.stdin.readline().rstrip().split()))
# x, y, 방향
character = list(map(int, sys.stdin.readline().rstrip().split()))
# 북 동 남 서
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
# 맵
map_list = []

for i in range(map_size[0]):
    map_list.append(list(map(int, sys.stdin.readline().rstrip().split())))

# 방문 지역은 2로 표헌
map_list[character[0]][character[1]] = 2

cnt = 0  # 좌회전 수, 4가 되면 전부 가봤거나 바다인 경우
ans = 1
while True:
    # x 축으로 움직인 방향 and y 축으로 움직인 방향이 방문하지 않은 육지인 경우
    turn_left()  # 왼쪽으로 방향 전환 즉, 1번과정 + 2번에서의 회전 과정
    cnt += 1
    if map_list[character[0] +
                dx[character[2]]][character[1] +
                                  dy[character[2]]] == 0:  # 가보지 않은 육지는 전진
        character[0] += dx[character[2]]
        character[1] += dy[character[2]]
        map_list[character[0]][character[1]] = 2  # 전진 후 가본 표시
        ans += 1  # 가본 곳 추가
        cnt = 0  # 이동했으니까 좌회전 수 초기화
    if cnt == 4:  # 네 방향 모두 이미 가본 칸이거나 바다로 되어 있는 칸의 경우
        if map_list[character[0] -
                    dx[character[2]]][character[1] -
                                      dy[character[2]]] != 1:  # 바다가 아닌 경우
            character[0] -= dx[character[2]]  # 후진
            character[1] -= dy[character[2]]  # 후진
            cnt = 0  # 이동했으니까 좌회전 수 초기화
        else:  # 바다인 경우 탈출
            break

print(ans)
"""
# 책의 풀이
# N, M을 공백을 기준으로 구분하여 입력받기
n, m = map(int, input().split())

# 방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화
d = [[0] * m for _ in range(n)]
# 현재 캐릭터의 X 좌표, Y 좌표, 방향을 입력받기
x, y, direction = map(int, input().split())
d[x][y] = 1 # 현재 좌표 방문 처리

# 전체 맵 정보를 입력받기
array = []
for i in range(n):
    array.append(list(map(int, input().split())))

# 북, 동, 남, 서 방향 정의
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# 왼쪽으로 회전
def turn_left():
    global direction
    direction -= 1
    if direction == -1:
        direction = 3

# 시뮬레이션 시작
count = 1
turn_time = 0
while True:
    # 왼쪽으로 회전
    turn_left()
    nx = x + dx[direction]
    ny = y + dy[direction]
    # 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
    if d[nx][ny] == 0 and array[nx][ny] == 0:
        d[nx][ny] = 1
        x = nx
        y = ny
        count += 1
        turn_time = 0
        continue
    # 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
    else:
        turn_time += 1
    # 네 방향 모두 갈 수 없는 경우
    if turn_time == 4:
        nx = x - dx[direction]
        ny = y - dy[direction]
        # 뒤로 갈 수 있다면 이동하기
        if array[nx][ny] == 0:
            x = nx
            y = ny
        # 뒤가 바다로 막혀있는 경우
        else:
            break
        turn_time = 0

# 정답 출력
print(count)
"""