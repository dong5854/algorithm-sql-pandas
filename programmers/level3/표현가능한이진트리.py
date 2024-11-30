"""
표현 가능한 이진 트리

https://school.programmers.co.kr/learn/courses/30/lessons/150367
"""
from math import log2

def isValid(root, tree):
    if len(tree) == 1:
        return True
    
    left_child = root - ((len(tree)+1) // 4)
    right_child = root + ((len(tree)+1) // 4)
    
    if int(tree[root]) == 0:
            if int(tree[left_child]) == 1 or int(tree[right_child]) == 1:
                return False

    left_tree = tree[:int(root)]
    left_valid = isValid(len(left_tree) // 2, left_tree)
    
    right_tree = tree[int(root)+1:]
    right_valid = isValid(len(right_tree) // 2, right_tree)
    
    return left_valid and right_valid
    
    

def solution(numbers):
    answer = []
    
    for number in numbers:
        # 0 은 트리가 만들어지지 않음
        if number == 0:
            answer = answer + [0]
            continue
            
        # 이진수 구하기
        binary_num = bin(number)[2:]
        
        # 포화이진트리 만들기
        while not log2(len(binary_num) + 1).is_integer():
            binary_num = '0' + binary_num

        # 부모 노드가 있는지 판별
        if isValid(len(binary_num) // 2, binary_num):
            answer = answer + [1]
        else:
            answer = answer + [0]
        
    
    return answer