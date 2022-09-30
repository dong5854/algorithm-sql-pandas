"""
네트워크

https://school.programmers.co.kr/learn/courses/30/lessons/43162
"""
def dfs(computers, computer, visited):
        for i in range(len(computer)):
            if computer[i] == 1 and visited[i] == False:
                visited[i] = True
                dfs(computers, computers[i], visited)
        return True

def solution(n, computers):
    visited = [False for _ in range(n)]
    answer = 0
    
    for i in range(n):
        if visited[i] == True:
            continue
        else:
            visited[i] = True
            if dfs(computers, computers[i],visited):
                answer += 1
    return answer