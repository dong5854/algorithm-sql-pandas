T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    stocks = list(map(int, input().split()))

    max_price = stocks[-1]
    pocket = []
    money = 0
    for i in range(N-2,-1, -1):
        if stocks[i] > max_price:
            max_price = stocks[i]
        else:
            money += max_price - stocks[i]

    print("#{} {}".format(test_case, money))
    
    
