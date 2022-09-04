"""
11723번
집합

https://www.acmicpc.net/problem/11723
"""
import sys

n = int(sys.stdin.readline().rstrip())
my_set = set()


def program(cmd: str, num: str):
    global my_set
    int_num = int(num)
    if cmd == "add":
        if int_num not in my_set:
            my_set.add(int_num)
    elif cmd == "check":
        if int_num in my_set:
            print(1)
        else:
            print(0)
    elif cmd == "remove":
        if int_num in my_set:
            my_set.remove(int_num)
    elif cmd == "toggle":
        if int_num in my_set:
            my_set.remove(int_num)
        else:
            my_set.add(int_num)
    elif cmd == "all":
        my_set = set([i for i in range(1, 21)])
    elif cmd == "empty":
        my_set = set()
    


for _ in range(n):
    command = sys.stdin.readline().rstrip()
    if " " in command:
        cmd, num = command.split()
    else:
        cmd, num = command, "0"
    program(cmd, num)