"""
10952번
A+B - 5

두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/10952
"""
while True:
    a,b = map(int,input().split())
    sum = a+b
    if sum == 0: break
    print("%d" %sum)