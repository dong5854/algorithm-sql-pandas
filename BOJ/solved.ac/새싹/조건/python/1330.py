"""
1330번
두 수 비교하기

두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/1330
"""
input_list = list(map(int, input().split()))
if input_list[0] > input_list[1]:
    print(">")
elif input_list[0] < input_list[1]:
    print("<")
else:
    print("==")