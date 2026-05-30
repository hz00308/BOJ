import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int len=s.length()/2; len>=1; len--) { // len: 자르는 단위
            // 해당 길이로 잘라서 큐에 넣기
            Queue<String> q = new ArrayDeque<>();
            int num = (int)Math.ceil((double)s.length()/len); // 요소의 개수
            for(int j=0; j<num; j++) {
                if(j==num-1) { // 마지막 요소
                    q.offer(s.substring(j*len));
                    break;
                }
                q.offer(s.substring(j*len, j*len+len));
            }
            
            int curr_len = 0;
            String curr_string = q.poll(); // 0번째 요소
            int cnt = 1;
            for(int j=1; j<num; j++) { // 1번쨰 요소~
                String front = q.poll();
                if(curr_string.equals(front)) { // 동일한 문자열 
                    cnt++;
                } else { // 다른 문자열 
                    if(cnt==1) {
                        curr_len += curr_string.length();
                    } else {
                        curr_len += curr_string.length() + String.valueOf(cnt).length();
                    }
                    curr_string = front;
                    cnt = 1;
                }
                if(q.isEmpty()) { // 마지막 요소 처리
                    if(cnt==1) {
                        curr_len += curr_string.length();
                    } else {
                        curr_len += curr_string.length() + String.valueOf(cnt).length();
                    }
                }
            }
            if(curr_len < answer) answer = curr_len;
        }
        return answer;
    }
}
/*
- 압축할 문자열 s
- 앞에서부터 일정한 단위로 문자열을 잘라 압축했을 때 가장 짧은 길이를 리턴 
*/
/*
- 문자열의 길이를 n이라고 했을 때,
- 압축이 불가한 경우의 길이(n)를 answer에 넣고 시작
- n/2부터 1까지 1씩 감소하며 테스트
- 해당 길이로 잘라서 큐에 넣기
- 큐에서 요소를 꺼내서 cnt를 1로 초기화
- 큐의 front 요소가 현재 요소와 동일한 동안 cnt++
- 큐의 front 요소가 현재 요소와 달라지면, curr_len에 요소의 길이와 cnt의 자릿수를 더하고 현재 요소 업데이트, cnt 초기화 
- curr_len을 answer과 비교하고 업데이트 
*/