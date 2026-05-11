class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] fact = {1,1,1,1,1,1,1,1,1,1};
        for(int i=2; i<=10; i++) { //i: 곱할 자연수
            fact[i-1] = fact[i-2]*i;
        }
        int idx = 0;
        while(idx<10 && fact[idx] <= n) {
            idx++;
        }
        return idx;
    }
}