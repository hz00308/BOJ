import java.util.*;
class Solution {
    List<List<Integer>> uniqueList;
    List<List<Integer>> candidateList;
    public int solution(String[][] relation) {
        uniqueList = new ArrayList<>();
        candidateList = new ArrayList<>();
        
        // uniqueList 구축
        dfs(new ArrayList<>(), 0, relation);
        
        // 최소성 검사로 candidateList 구축
        uniqueList.sort((a, b) -> a.size() - b.size());
        for(List<Integer> u : uniqueList) {
            boolean isMinimal = true;
            for(List<Integer> c : candidateList) {
                if(u.containsAll(c)) {
                    isMinimal = false;
                    break;
                }
            }
            if(isMinimal) candidateList.add(u);
        }
        
        
        return candidateList.size();
    }
    // 공집합을 제외한 부분집합을 검사할 예정  
    private void dfs(List<Integer> key, int col, String[][] relation) {
        // 유일성 검사 후 uniqueList에 추가
        if(col==relation[0].length) {
            if(key.size()==0) return;
            // 유일성 검사
            Set<List<String>> set = new HashSet<>();
            // 각 튜플 돌면서 List<String> 만들어서 set에 넣기
            for(String[] r : relation) {
                // key 돌면서 해당 컬럼 추가
                List<String> list = new ArrayList<>();
                for(int k : key) {
                    list.add(r[k]);
                }
                set.add(list);
            }
            if(set.size()==relation.length) {
                uniqueList.add(new ArrayList<>(key));
            }
            return;
        }
        dfs(key, col+1, relation); //추가X
        key.add(col); ///
        dfs(key, col+1, relation);
        key.remove(key.size()-1); ///col로 하면 인덱스여서 에러 
        
    }
    
} 
/*
- relation: 릴레이션을 나타내는 문자열 배열
- 릴레이션의 후보키 개수 리턴 
*/
/*
- 모든 컬럼의 부분집합을 검사 (공집합 제외)
- 각 부분집합마다 중복 확인 
*/