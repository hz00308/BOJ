import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);
        for(int i : d) {
            sum+=i;
            answer++;
            if(sum == budget) break;
            else if (sum > budget) {
                answer--;
                break;
            };
        }
        return answer;
    }
}