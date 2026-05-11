class Solution {
    public int solution(int n) {
        //에라토스테네스의 체 연습
        boolean[] prime = new boolean[101]; //1~100 (기본값 false)
        for(int i=2; i<101; i++) {
            prime[i] = true; //모두 소수라고 가정하고 시작
        }
        for(int i=2; i*i<101; i++) {
            if(prime[i]) { //소수가 아니면 이미 처리했으므로 넘어감
                for(int j=i*i; j<101; j+=i) {
                    prime[j] = false;
                }
            }
        }
        int answer = 0;
        for(int i=2; i<=n; i++) {
            if(!prime[i]) answer++;
        }
        return answer;
    }
}