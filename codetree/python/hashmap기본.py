import sys

def print_result(command : str, input1 : str, input2 : str = None):
    if command == "add":
        hashmap[input1] = input2
    elif command == "find":
        print(hashmap[input1]) if input1 in hashmap else print("None")
    elif command == "remove":
        hashmap.pop(input1)

input = sys.stdin.readline
hashmap = dict()

n = int(input().rstrip())

for i in range(n):
    commands = input().rstrip().split()
    if len(commands) == 2:
        print_result(commands[0], commands[1])
    else:
        print_result(commands[0], commands[1], commands[2])
