class Solution {
    public String solution(String my_string, String letter) {
        String answer = my_string.replace(letter, "");
        // replace()를 사용해 특정 문자를 삭제할 때, 두 번째 인자를 ''이 아닌 ""로 주어야 함 
        // Java String은 불변이므로 원본은 변하지 않으며, 항상 새로운 문자열이 반환됨
        return answer;
    }
}