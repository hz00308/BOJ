class Solution {
    public int[] solution(int n) {
        int num = (n+1)/2; // 반올림 
        int[] arr = new int[num];
        int index = 0;
        for(int i=1; i<=n; i=i+2) {
            arr[index] = i;
            index++;
        }
        return arr;
    }
}