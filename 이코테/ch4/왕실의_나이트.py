# 내 풀이
n = input()
row = int(n[1])
column = ord(n[0]) - 96
ans = 0

# 2칸이동의 4가지 경우의 수
for i in range(4):
    flag = True
    # 위
    if i == 0:
        if column < 3:
            flag = False
    # 아래
    elif i == 1:
        if column > 6:
            flag = False
    # 좌
    elif i == 2:
        if row < 3:
            flag = False
    # 우
    else:
        if row > 6:
            flag = False

    # 1칸 이동의 2가지 경우의 수
    # 어차피 못함
    if flag is False:
        continue
    # 위 아래
    if i == 0 or i == 1:
        if row > 1:
            ans += 1
        if row < 8:
            ans += 1
    # 좌 우
    else:
        if column > 1:
            ans += 1
        if column < 8:
            ans += 1

print(ans)
"""
# 책의 풀이
# 현재 나이트의 위치 입력받기
input_data = input()
row = int(input_data[1])
column = int(ord(input_data[0])) - int(ord('a')) + 1

# 나이트가 이동할 수 있는 8가지 방향 정의
steps = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2),
         (-2, 1)]

# 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
result = 0
for step in steps:
    # 이동하고자 하는 위치 확인
    next_row = row + step[0]
    next_column = column + step[1]
    # 해당 위치로 이동이 가능하다면 카운트 증가
    if next_row >= 1 and next_row <= 8 and next_column >= 1 and next_column <= 8:
        result += 1

print(result)
"""