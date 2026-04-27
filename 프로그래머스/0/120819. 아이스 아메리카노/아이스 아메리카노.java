class Solution {
    public int[] solution(int money) {
        int cnt = money/5500;
        int left = money - cnt*5500;
        int[] answer = {cnt, left};
        return answer;
    }
}