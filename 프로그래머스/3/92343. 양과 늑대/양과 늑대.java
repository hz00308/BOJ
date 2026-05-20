import java.util.*;
class Solution {
    int answer = 0;
    boolean[] visited;
    public int solution(int[] info, int[][] edges) {

        visited = new boolean[info.length];
        visited[0] = true;
        dfs(0, 1, 0, info, edges);
        
        return answer;
    }
    private void dfs(int node, int sheep, int wolf, int[] info, int[][] edges) {
        if(sheep<=wolf) return;
        answer = Math.max(answer, sheep);
        for(int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            if(visited[parent] && !visited[child]) {
                visited[child] = true;
                if(info[child]==0) dfs(child, sheep+1, wolf, info, edges);
                else dfs(child, sheep, wolf+1, info, edges);
                visited[child] = false;
            }
        }
        
    }

}