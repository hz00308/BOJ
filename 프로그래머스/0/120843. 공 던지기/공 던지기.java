class Solution {
    public int solution(int[] numbers, int k) {
        int idx = ((k-1)*2)%numbers.length;
        int answer = numbers[idx];
        return answer;
    }
}