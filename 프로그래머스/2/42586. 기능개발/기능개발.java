import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] duration = new int[progresses.length];
        for(int i=0; i<progresses.length; i++) {
            int left = 100 - progresses[i];
            duration[i] = (int)Math.ceil((double)left/speeds[i]);
        }

        int first = -1;
        int release = -1;
        int[] answer = new int[duration.length];
        for(int i=0; i<duration.length; i++) {
            if(duration[i] > first) {
                first = duration[i];
                release++;
                answer[release] = 1;
            } else {
                answer[release]++;
            }
        }
        
        return Arrays.copyOfRange(answer, 0, release+1);
    }
}
/*
- 각 기능은 진도가 100%일 때 서비스에 반영 가능
- 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발되더라도 앞에 있는 기능과 함께 배포됨 
- progresses: 배포해야 하는 순서대로 작업의 진도가 적힌 배열
- speeds: 배포해야 하는 순서대로 개발 속도가 적힌 배열
- 각 배포마다 몇 개의 기능이 배포되는지 리턴 (유효한 배포만 고려)
*/
/*
- progresses, speeds 돌면서 개발에 소요되는 일수 계산 => duration
- duration을 돌면서, 소요일수가 해당 배포의 첫 기능보다 많은 경우 새로운 배포
- 소요일수가 해당 배포의 첫 기능보다 적은 경우 해당 배포에 배포될 기능 +1 
*/