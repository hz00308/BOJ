import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        // 동서남북 이동 가능 
        // 상대 진영에 도착하기 위해 지나야 하는 칸 개수의 최솟값 리턴 (불가하면 -1)
        // maps: n*m 2차원 배열
        // 0: 벽
        // 1: 길 
        // (1, 1) ---> (n, m)
        int answer = 0;
        
        // grid(상하좌우): maps
        // 재료 준비(6개)
        int n = maps.length;
        int m = maps[0].length;
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        Queue<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                visited[i][j] = -1;
            }
        }
        
        // (0, 0) ---> (n-1, m-1) 으로 생각
        // (0, 0)을 시작 노드로 bfs (거리 저장)
        // 거리는 (0, 0)이 1로 시작 
        q.offer(new int[]{0, 0});
        visited[0][0] = 1;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int currCnt = visited[r][c];
            for(int i=0; i<4; i++) { //4방향
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && maps[nr][nc]==1) {
                    if(visited[nr][nc]==-1) {
                        q.offer(new int[]{nr, nc});
                        visited[nr][nc] = currCnt + 1;
                    }
                }
            }
        }
        
        // (n-1, m-1)의 거리 정보 리턴 
        answer = visited[n-1][m-1];
        return answer;
    }
}