"""
2744번
대소문자 바꾸기

영어 소문자와 대문자로 이루어진 단어를 입력받은 뒤, 대문자는 소문자로, 소문자는 대문자로 바꾸어 출력하는 프로그램을 작성하시오.
https://www.acmicpc.net/problem/2744
"""
input = input()

for i in input:
    if(ord(i)>=97):
        print(i.upper(), end="")
    else:
        print(i.lower(), end="")

"""
파이썬은 swapcase 함수로 더 쉽게 가능

print(input().swapcase())
"""