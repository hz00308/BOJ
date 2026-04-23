class Solution {
    public int solution(int n) {
        int answer = (int)Math.ceil(n/7.0);
        // Math.ceil은 double을 받아 double을 리턴함을 유의 
        return answer;
    }
}