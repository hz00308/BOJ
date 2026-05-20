import java.util.*;
class Solution {
    int answer;
    boolean[] colUsed;
    Set<Integer> diag1;
    Set<Integer> diag2;
    public int solution(int n) {
        answer = 0;
        colUsed = new boolean[n];
        diag1 = new HashSet<>();
        diag2 = new HashSet<>();
        dfs(0, n);
        return answer;
    }
    private void dfs(int row, int n) {
        if(row==n) {
            answer++;
            return;
        }
        for(int col=0; col<n; col++) {
            if(colUsed[col]) continue;
            // 대각선 확인
            if(diag1.contains(row+col)) continue;
            if(diag2.contains(row-col)) continue;
            
            colUsed[col] = true;
            diag1.add(row+col);
            diag2.add(row-col);
            dfs(row+1, n);
            colUsed[col] = false;
            diag1.remove(Integer.valueOf(row+col));
            diag2.remove(Integer.valueOf(row-col));
        }
    }
}