"""
1003번
피보나치 함수

https://www.acmicpc.net/problem/1003
"""
# dp를 사용해서 푼다고 한다 해당 내용 공부 후 다시 해보기
# https://itstory1592.tistory.com/34
zero = [1, 0, 1]
one = [0, 1, 1]

def fibonacci(num):
    length = len(zero)
    if num >= length:
        for i in range(length, num+1):
            zero.append(zero[i-1] + zero[i-2])
            one.append(one[i-1] + one[i-2])
    print('{} {}'.format(zero[num], one[num]))

T = int(input())
    
for _ in range(T):
    fibonacci(int(input()))