import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = new int[privacies.length];
        int cnt = 0; // 파기할 개인정보 개수 
        
        // terms 돌면서 HashMap<약관종류, 유효기간> hashTerms 구축
        Map<String, Integer> hashTerms = new HashMap<>();
        for(String t : terms) {
            String[] infos = t.split(" ");
            String type = infos[0];
            int months = Integer.parseInt(infos[1]);
            hashTerms.put(type, months);
        }
        
        //privacies 돌면서,
        //자신의 '날짜'에 해당 약관종류의 유효기간을 더하여 파기일을 구함
        //오늘 날짜가 파기일 이상이면 파기해야 할 개인정보
        for(int i=0; i<privacies.length; i++) {
            String[] infos = privacies[i].split(" ");
            String cDate = infos[0];
            String type = infos[1];
            
            String dDate = addMonth(cDate, hashTerms.get(type));
            if(today.compareTo(dDate) >= 0) {
                // String의 compareTo 메서드 반환값
                // 0: 동일
                // 음수: 기준문자열 < 대상문자열 (사전순)
                // 양수: 기준문자열 > 대상문자열 (사전순)
                answer[cnt] = i+1;
                cnt++;
            }
        }
        
        return Arrays.copyOfRange(answer, 0, cnt);
    }
    private String addMonth(String cDate, int months) {
        String[] ymd = cDate.split("\\."); // split은 정규식을 파라미터로 받으므로 이스케이프 필요 
        int year = Integer.parseInt(ymd[0]);
        int month = Integer.parseInt(ymd[1]);
        month += months;
        year += (month-1)/12;
        month = (month-1)%12 + 1;
        return String.format("%d.%02d.%s", year, month, ymd[2]);
    }
}
/*
- 개인정보 n개
- 약관 --> 개인정보 수집 
- 오늘 날짜로 파기해야 할 개인정보 번호들 구하기
- 모든 달은 28일까지로 가정
- today: 오늘 날짜 (YYYY.MM.DD)
- terms: 약관 유효기간을 담은 1차원 문자열 배열 "약관종류 유효기간"
    - 약관종류: A~Z (중복X)
    - 유효기간: 1~100(달)
- privacies: 개인정보 정보를 담은 1차원 문자열 배열 
    - privacies[i]: i+1번 개인정보의 "날짜 약관종류"
- 파기해야 할 개인정보 번호를 오름차순으로 1차원 정수 배열에 담아 리턴 
*/
/*
- terms 돌면서 HashMap<약관종류, 유효기간> hashTerms 구축
- privacies 돌면서,
    - 자신의 '날짜'에 해당 약관종류의 유효기간을 더하여 파기일을 구함
    - 오늘 날짜가 파기일 이상이면 파기해야 할 개인정보 
- 파기일 구하는 함수: DD는 동일, MM/YYYY 업데이트 
*/