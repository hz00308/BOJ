class Solution {
    Map<String, List<String>> map;
    public List<List<String>> groupAnagrams(String[] strs) {
        map = new HashMap<>();
        for(String s : strs) {
            String sortedKey = sortString(s);
            if(map.containsKey(sortedKey)) {
                map.get(sortedKey).add(s);
            } else {
                List<String> value = new ArrayList<>();
                value.add(s);
                map.put(sortedKey, value);
            }
        }
        // 정답 리스트로 변환 
        List<List<String>> answer = new ArrayList<>();
        for(String k : map.keySet()) {
            answer.add(map.get(k));
        }
        return answer;

    }
    private String sortString(String old) {
        char[] arr = old.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    private boolean isAnagram(String key, String curr) {
        return key.equals(sortString(curr)) ? true : false;
    }
}
/*
- strs: String 배열
- 애너그램끼리 묶은 배열의 배열 리턴
*/
/*
- 애너그램인지 판단: 정렬 후 비교 => isAnagram(String key, String curr)
- HashMap<정렬된 애너그램, 애너그램 리스트>
- strs를 돌면서, HashMap에 애너그램이 있는 경우 리스트에 추가, 없으면 새 엔트리 생성
- 각 엔트리의 리스트를 정답 리스트에 넣기 
*/