from collections import deque

def solution(n, computers):
    # 인접 리스트 변환
    # 0~n-1 노드 돌면서 방문 안 된 노드라면
    # cnt 올리고 
    # bfs 실행 
    
    graph = [[] for _ in range(n)]
    
    for i in range(n-1):
        for j in range(1, n):
            if computers[i][j] == 1:
                graph[i].append(j)
                graph[j].append(i)
    
    cnt = 0
    q = deque()
    visited = [False]*n
    
    for i in range(n):
        if visited[i]:
            continue
            
        # 아직 방문 X 
        cnt+=1
        
        #bfs
        q.append(i)
        visited[i] = True
        while q:
            cv = q.popleft()
            for nv in graph[cv]:
                if not visited[nv]:
                    q.append(nv)
                    visited[nv] = True
                
    return cnt