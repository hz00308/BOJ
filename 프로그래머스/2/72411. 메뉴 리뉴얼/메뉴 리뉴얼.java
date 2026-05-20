import java.util.*;
class Solution {
    List<String> answer;
    public String[] solution(String[] orders, int[] course) {
        answer = new ArrayList<>();
        // dishCnt에 대해...
        // order 하나에 대해...
        for(int dishCnt : course) {
            Map<String, Integer> map = new HashMap<>();
            for(String order : orders) {
                // order 알파벳순 정렬
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                String sortedOrder = new String(arr);
                // 해당 order(sortedOrder)에 대해 dfs로 map 갱신 
                // dishCnt개를 선택해서 map 갱신 
                dfs("", 0, dishCnt, sortedOrder, map);
            }
            // 최고 value 구하고 2 미만이면 스킵
            int maxVal = 0;
            for(int val : map.values()) {
                maxVal = Math.max(maxVal, val);
            }
            if(maxVal < 2) continue;
            for(String s : map.keySet()) {
                if(map.get(s)==maxVal) answer.add(s);
            }
        }
        
        // 리스트를 정답 배열로 
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    private void dfs(String curr, int start, int dishCnt, String order, Map<String, Integer> map) {
        if(curr.length()==dishCnt) {
            map.put(curr, map.getOrDefault(curr, 0)+1);
            return;
        }
        for(int i=start; i<order.length(); i++) {
            dfs(curr+order.charAt(i), i+1, dishCnt, order, map);
        }
        
    }
    
}
/*
- 이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 함
- 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성
- 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함
- orders: 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열
- course: 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열
- 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 리턴 (사전순 정렬) 
- 만약 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담아 리턴 
*/