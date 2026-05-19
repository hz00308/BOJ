import java.util.*;
class Solution {
    List<List<Integer>> tree;
    boolean[] visited;
    int answer;
    public int solution(int[] info, int[][] edges) {
    
        visited = new boolean[info.length];
        visited[0] = true;
        int sheep = 1;
        int wolf = 0;
        dfs(0, info, edges, sheep, wolf);
        
        return answer;
    }
    private void dfs(int node, int[] info, int[][] edges, int sheep, int wolf) {
        if(wolf >= sheep) return;
        answer = Math.max(answer, sheep);
        for(int[] e : edges) {
            int parent = e[0];
            int child = e[1];
            if(visited[parent] && !visited[child]) {
                visited[child] = true;
                if(info[child]==0) dfs(child, info, edges, sheep+1, wolf);
                else dfs(child, info, edges, sheep, wolf+1);
                visited[child] = false;
            }
        }
    }
}
/*
- 이진 트리 모양 초원 
- 각 노드를 방문할 때마다 해당 노드의 양과 늑대가 따라옴
- "양의 수 <= 늑대의 수"가 되면, 늑대가 모든 양을 잡아먹음
- 양이 늑대에게 잡아먹히지 않도록 하면서 최대한 많은 수의 양을 모아서 루트 노드로 돌아오는 것이 목표 
- 루트(0번) 노드는 항상 양
- info: 각 노드의 양/늑대 정보 (0: 양, 1: 늑대)
- edges: [부모, 자식]을 요소로 하는 간선 리스트 (2차원 배열) 
*/
/*
- 간선 리스트 --> 인접 리스트 tree 구축 
- 탐색 알고리즘? 
- 다음 노드: 현재까지 방문한 모든 노드의 다음 노드 중 방문 안 한 노드들  
- 다음 노드 중 양 노드가 있다면 일단 양 노드로 간다
- 늑대 노드밖에 없다면, ... 흠 
*/