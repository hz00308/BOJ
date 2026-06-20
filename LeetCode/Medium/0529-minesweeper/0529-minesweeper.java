class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int cr = click[0];
        int cc = click[1];

        if(board[cr][cc] == 'M') {
            board[cr][cc] = 'X';
            return board;
        }

        // board[cr][cc] == 'E'
        int m = board.length;
        int n = board[0].length;
        int[] dr = {0, 0, 1, -1, 1, 1, -1, -1};
        int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};
        Queue<int[]> q = new ArrayDeque<>();
        // visited는 board로 대체 (방문 표시 = 칸 공개) 

        // 인접 지뢰 개수 미리 구해두기
        char[][] mines = new char[m][n];
        for(int r=0; r<m; r++) {
            for(int c=0; c<n; c++) {
                if(board[r][c]!='M') continue;
                for(int i=0; i<8; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if(nr>=0 && nr<m && nc>=0 && nc<n) {
                        mines[nr][nc] += 1;
                    }
                } 
            }
        }

        if(mines[cr][cc]==0) {
            q.offer(click);
            board[cr][cc] = 'B';
        } else {
            board[cr][cc] = (char)(mines[cr][cc] + '0');
        }
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int i=0; i<8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i]; 
                if(nr>=0 && nr<m && nc>=0 && nc<n && board[nr][nc]=='E') {
                    if(mines[nr][nc]==0) {
                        q.offer(new int[]{nr, nc});
                        board[nr][nc] = 'B';
                    } else {
                        board[nr][nc] = (char)(mines[nr][nc] + '0');
                    }
                }
            }
        }

        return board;
    }
}
/*
- board: char[m][n]
- M: 비공개 지뢰
- E: 비공개 빈칸
- B: 공개 빈칸 (인접 8방향 지뢰X)
- 1~8: 이 공개된 칸 주변 지뢰 개수  
- X: 공개 지뢰
- click: {r, c} --> 다음 클릭 위치 (M 또는 E)
- 클릭 후 보드 상태를 리턴
    - M --> X (게임오버)
    - E(인접 지뢰X) --> B + 인접 칸들 재귀적으로 공개 
    - E(인접 지뢰O) --> 1~8  
*/
/*
- 클릭한 칸이 M이면 X로 변경 후 바로 리턴
- 클릭한 칸이 E면
- 해당 칸 큐에 넣고 bfs
- 다음 노드: 8방향 & E
    - 다음 노드가 B면 보드에 표시하고 큐에 넣음
    - 숫자면 보드에 숫자만 표시 
*/