import java.util.*;
class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int[] dr = {1, 0, 0, -1}; // dlru 순서
        int[] dc = {0, -1, 1, 0};
        String[] ds = {"d", "l", "r", "u"};
        Queue<String[]> q = new ArrayDeque<>();
        int[][] visited = new int[n+1][m+1]; // 문자열 길이 저장 (같은 길이 문자열은 사전순 후순위이므로, 더 긴 문자열인 경우에만 재방문 가능하도록 함)
        
        q.offer(new String[] {String.valueOf(x), String.valueOf(y), ""});
        //visited[x][y] = 0;
        
        while(!q.isEmpty()) {
            String[] curr = q.poll();
            int cr = Integer.parseInt(curr[0]);
            int cc = Integer.parseInt(curr[1]);
            String cs = curr[2];
            
            if(cs.length() == k) {
                if(cr==r && cc==c) return cs;
                else continue;
            }
            
            for(int i=0; i<4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                String ns = cs + ds[i];
                if(nr>=1 && nr<=n && nc>=1 && nc<=m && visited[nr][nc]<ns.length()) {
                    q.offer(new String[]{String.valueOf(nr), String.valueOf(nc), ns});
                    visited[nr][nc] = ns.length();
                }
            }
        }
        
        return "impossible";
    }
}
/*
- n*m 격자 미로
- (x,y) --> (r,c) 탈출
- 이동 거리가 총 k여야 함 (격자 중복 방문 가능)
- 탈출 경로 문자열이 사전 순으로 가장 빠른 경로여야 함 (d -> l -> r -> u)
- 탈출 불가한 경우 "impossible"
*/
/*
- String[] {"x", "y", ""}을 시작으로 bfs
- 다음 노드: 상하좌우 이동 (dlru 순서) 
- 문자열 길이가 k가 되면 (r,c)와 비교
*/