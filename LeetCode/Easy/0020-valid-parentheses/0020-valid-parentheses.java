class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for(char c : chars) {
            if(c=='(') {
                stack.push(')');
            } else if (c=='{') {
                stack.push('}');
            } else if (c=='[') {
                stack.push(']');
            } else { // ), }, ]
                if(stack.isEmpty()) {
                    return false;
                } else {
                    if(c==stack.pop()) continue;
                    else return false;
                }
            }
        }
        return stack.isEmpty();
    }
}