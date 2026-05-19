import java.util.*;
class Solution {
    List<List<Integer>> graph;
    int[] subtreeSize;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        // 인접 리스트 구성
        graph = new ArrayList<>();
        for(int i=0; i<n+1; i++) { //0번 송전탑은 없음
            graph.add(new ArrayList<>());
        }
        for(int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        subtreeSize = new int[n+1]; //0번 송전탑 서브트리는 없음
        visited = new boolean[n+1]; //0번 송전탑은 없음
        
        dfs(1); //1번 송전탑을 루트로 dfs
        
        int answer = 100;
        for(int i=2; i<n+1; i++) {
            int diff = Math.abs(n - 2*subtreeSize[i]);
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    
    private int dfs(int node) {
        visited[node] = true; // 앞으로 서브트리 크기를 계산할 것이므로 이 노드는 다시 방문할 일이 없음. 따라서 전역변수 visited[node]를 true로 설정함.
        subtreeSize[node] = 1; // 자기 자신 포함이므로
        
        for(int neighbor : graph.get(node)) {
            if(visited[neighbor]) continue;
            dfs(neighbor);
            subtreeSize[node] += subtreeSize[neighbor];
        }
        
        return subtreeSize[node];
    }
    
}
