class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder(my_string).reverse();
        String answer = sb.toString();
        return answer;
    }
}