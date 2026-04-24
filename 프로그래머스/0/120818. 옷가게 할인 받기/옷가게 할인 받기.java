class Solution {
    public int solution(int price) {
        double ratio = 1.0;
        if (price >= 500000) {
            ratio = 0.8;
        } else if (price >= 300000) {
            ratio = 0.9;
        } else if (price >= 100000) {
            ratio = 0.95;
        }
        int answer = (int)(price*ratio);
        return answer;
    }
}