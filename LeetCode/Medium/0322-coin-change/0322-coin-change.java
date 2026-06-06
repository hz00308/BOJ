class Solution {
    public int coinChange(int[] coins, int amount) {
        boolean[] visited = new boolean[amount+1];
        Queue<int[]> q = new ArrayDeque<>();
        
        if(amount==0) return 0;

        q.offer(new int[]{0, 0});
        visited[0] = true;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int sum = curr[0];
            int cnt = curr[1];
            for(int coin : coins) {
                int new_sum = sum + coin;
                if(new_sum == amount) return cnt+1;
                if(new_sum > amount || visited[new_sum]) continue;
                q.offer(new int[]{new_sum, cnt+1});
                visited[new_sum] = true;
            }
        }
        return -1;
    }
}
/*
- coins: 동전 값의 종류를 나타내는 배열 
- amount: 목표 값 
*/
/*
- bfs
- visited[i]: 0 ~ amount까지 
- 큐에 int[] 넣기(합계, 개수)
- 큐에서 하나 꺼내고 coins 돌면서 동전 값 더하기
- 더한 합계가 amount 이하이고, visited가 false인 경우 큐에 넣기
- 더한 합계가 amount이면 리턴
*/