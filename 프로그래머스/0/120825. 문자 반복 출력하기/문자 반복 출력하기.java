class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<my_string.length(); i++) {
            for (int j=0; j<n; j++) {
                sb.append(my_string.charAt(i));
                //java는 C와 달리 배열 인덱스로 문자열의 문자 접근 불가능. charAt() 사용!
            }
        }
        String answer = sb.toString();
        return answer;
    }
}