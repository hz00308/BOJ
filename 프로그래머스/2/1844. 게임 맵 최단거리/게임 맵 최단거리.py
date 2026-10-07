from collections import deque
def solution(maps):
    
    n, m = len(maps), len(maps[0])
    dr = [1, -1, 0, 0]
    dc = [0, 0, 1, -1]
    q = deque()
    visited = [[0]*(m+1) for _ in range(n+1)]
    
    q.append((1, 1))
    visited[1][1] = 1
    
    while q:
        r, c = q.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if(1<=nr<=n and 1<=nc<=m and maps[nr-1][nc-1]==1 and visited[nr][nc]==0):
                q.append((nr, nc))
                visited[nr][nc] = visited[r][c] + 1
    
    return -1 if visited[n][m]==0 else visited[n][m]

'''
(1,1)에서 시작해서 bfs 
bfs 끝나고 (n,m)가 visited 아니면 -1 리턴
0: 벽
1: 길 
'''