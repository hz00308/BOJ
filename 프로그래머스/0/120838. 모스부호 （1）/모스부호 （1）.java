import java.util.*;
class Solution {
    public String solution(String letter) {
        String answer = "";
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        List<String> morseList = Arrays.asList(morse);
        String[] letterArray = letter.split(" ");
        for(String l : letterArray) {
            int idx = morseList.indexOf(l);
            answer += (char)(idx+'a');
        }
        
        return answer;
    }
}