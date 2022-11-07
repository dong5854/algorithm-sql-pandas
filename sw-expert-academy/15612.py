T = int(input())
for test_case in range(1, T + 1):
    chess_board = []
    clear_list = [0 for _ in range(8)]

    flag = False
    rooks = 0
    for _ in range(8):
        chess_line = input()
        row = False
        for i in range(8):
            if chess_line[i] == "O":
                # 룩 개수 추가
                rooks += 1
                # 열 확인
                if clear_list[i] == 0:
                    clear_list[i] += 1
                elif clear_list[i] != 0:
                    flag = True

                # 행 확인
                if row is False:
                    row = True
                else:
                    flag = True


    if flag is True or rooks != 8:
        print("#{} no".format(test_case))
    else:
        print("#{} yes".format(test_case))
