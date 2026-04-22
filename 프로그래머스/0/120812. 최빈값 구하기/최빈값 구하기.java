class Solution {
    public int solution(int[] array) {
        int[] cnt = new int[1000];
        for (int i : array) {
            cnt[i]++;
        }
        int max = 0;
        for (int i : cnt) {
            if (max < i) max = i;
        }
        int cntmax = 0;
        int index = -1;
        for (int i = 0; i < 1000; i++) {
            if (cnt[i] == max) {
                index = i;
                cntmax++;
            }
            if (cntmax == 2) {
                index = -1;
                break;
            }
        }
        return index;
    }
}