class Solution {
    public int[] solution(int[] emergency) {
        // emergency 배열과 동일 길이의 answer 배열 만들고
        // for문 (1~) 돌면서 max 찾기 -> 0으로 설정 
        int len = emergency.length;
        int[] answer = new int[len];
        for(int i=1; i<=len; i++) { // i: 순위
            int max = 0;
            int max_idx = 0;
            for(int j=0; j<len; j++) { // j: 배열 인덱스
                if (emergency[j] > max) {
                    max = emergency[j];
                    max_idx = j;
                }
            }
            answer[max_idx] = i;
            emergency[max_idx] = 0;
        }
        return answer;
    }
}