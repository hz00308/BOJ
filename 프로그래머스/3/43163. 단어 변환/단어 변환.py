from collections import deque
def solution(begin, target, words):
    
    # words 돌면서 dict 만들기 
    # 단어 길이가 n일 때, n-1개가 일치하면 연결된 것 
    
    if target not in words:
        return 0
    
    words.append(begin)
    graph = {w: [] for w in words}
    for w1 in words:
        for w2 in words:
            diff = 0
            for a, b in zip(w1, w2):
                if a!=b:
                    diff+=1
            if diff==1:
                graph[w1].append(w2)
    
    q = deque()
    dist = {w: -1 for w in words}
    q.append(begin)
    dist[begin] = 0
    
    while q:
        curr = q.popleft()
        for next in graph[curr]:
            if dist[next] == -1:
                q.append(next)
                dist[next] = dist[curr] + 1
    
    return 0 if dist[target] == -1 else dist[target]


"""
단어 begin, target 
집합 words
모든 단어의 길이는 같음, 중복X
begin != target 
변환 불가능한 경우 0 리턴 
---
인접리스트 만들기
begin 단어를 0으로 해서 bfs
target 단어의 거리 리턴 (못 가면 0)
"""