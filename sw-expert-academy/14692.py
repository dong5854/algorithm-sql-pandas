T = int(input())

gamers = ["Alice", "Bob"]
for test_case in range(1, T + 1):
    N = int(input())

    if N % 2 == 0:
        print("#{} {}".format(test_case, gamers[0]))
    else:
        print("#{} {}".format(test_case, gamers[1]))
