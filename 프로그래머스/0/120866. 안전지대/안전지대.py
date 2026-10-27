def solution(board):
    n = len(board)
    
    # 지뢰 좌표 찾기 
    bombs = []
    for i in range(n):
        for j in range(n):
            if board[i][j]==1:
                bombs.append((i, j))
    
    # 위험지역 마킹
    dx = [1, -1, 0, 0, 1, 1, -1, -1]
    dy = [0, 0, 1, -1, 1, -1, 1, -1]
    for cx, cy in bombs:
        for i in range(8):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                board[nx][ny] = 1
    
    # 1 개수 세기
    cnt = 0
    for b in board:
        cnt += sum(b)
        
    return n*n - cnt