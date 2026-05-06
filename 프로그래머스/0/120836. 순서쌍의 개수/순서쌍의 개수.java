class Solution {
    public int solution(int n) {
        // for문: i = 1 ~ 루트 n 
        // n%i==0인 경우, 순서쌍 존재
        // i*i == n인 경우 +1, 그외 +2
        int answer = 0;
        for(int i=1; i<=Math.sqrt(n); i++) {
            if(n%i==0) {
                if(i*i==n) answer++;
                else answer+=2;
            }
        }
        return answer;
    }
}