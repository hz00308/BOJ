class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = toSeconds(play_time);
        int advSec = toSeconds(adv_time);
        
        long[] delta = new long[playSec + 2];
        for(String log : logs) {
            String[] parts = log.split("-");
            int startSec = toSeconds(parts[0]);
            int endSec = toSeconds(parts[1]);
            delta[startSec]++; // 시청 시작
            delta[endSec]--; // 시청 종료
        }
        
        // 누적합1: 각 초의 동시 시청자 수 (각 초의 동시 시청자수)
        for(int i=1; i<=playSec; i++) {
            delta[i] += delta[i-1];
        }
        // 누적합2: 0초부터 해당 시각까지의 총 시청 시간
        for(int i=1; i<=playSec; i++) {
            delta[i] += delta[i-1];
        }
        
        // 광고 시작 시각 0일 때 누적 시청시간
        long maxTime = delta[advSec-1];
        int answer = 0;
        
        // 광고 시작 시각을 1초부터 이동하며 최대값 탐색
        for(int start=1; start<=playSec-advSec; start++) {
            int end = start + advSec - 1;
            long currentTime = delta[end] - delta[start-1];
            if(currentTime > maxTime) {
                maxTime = currentTime;
                answer = start;
            }
        }
        
        return toTimeStr(answer);
    }
    private int toSeconds(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        return h*3600 + m*60 + s;
    }
    private String toTimeStr(int seconds) {
        int h = seconds/3600;
        int m = (seconds%3600)/60;
        int s = seconds%60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
/*
- 시청자들이 가장 많이 보는 구간에 공익광고를 넣으려고 함 
- play_time: 동영상 길이 (HH:MM:SS)
- adv_time: 광고 길이 (HH:MM:SS)
- logs: 동영상 재생 구간 정보 (각 원소는 H1:M1:S1-H2:M2:S2)
- 시청자들의 누적 재생시간이 가장 많이 나오는 곳에 공익광고를 삽입하려고 함 
- 공익광고 시작 시각을 리턴 (가장 빠른 시작 시각) (HH:MM:SS) 
*/
/*
- 99 * 59 * 59 = 약 360,000 개의 시간을 순차 탐색 (play_time 까지)
- 
*/