"""
단어 변환

https://school.programmers.co.kr/learn/courses/30/lessons/43163#
"""

answer = 50
visited = [False for _ in range(50)]


# 다른 글자가 두개 이상인 것을 찾는 함수
def one_diff(word1, word2):
    val = 0
    for i in range(len(word1)):
        if word1[i] != word2[i]:
            val += 1
        if val > 1:
            break

    return val == 1
    
def dfs(current, target, words, length, step):
    global answer, visited
    # 이미 더 짧은 경로를 구해둔 경우
    if step > answer:
        return
    
    # 일치할 때
    if current == target:
        answer = min(step, answer)
        return
    
    
    for i in range(length):
        if visited[i] == False and one_diff(current, words[i]):
            visited[i] = True
            dfs(words[i], target, words, length, step+1)
            visited[i] = False
    
    return
    

def solution(begin, target, words):
    global answer
    length = len(words)
    
    # 변환할 수 없는 경우
    if target not in words:
        return 0
    
    dfs(begin, target, words, length, 0)
    
    return  answer