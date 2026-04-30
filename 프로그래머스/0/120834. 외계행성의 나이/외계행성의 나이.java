class Solution {
    public String solution(int age) {
        char[] toChar = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        String answer = "";
        while(age != 0) {
            int digit = age%10;
            answer = toChar[digit] + answer;
            age /= 10;
        }
        return answer;
    }
}