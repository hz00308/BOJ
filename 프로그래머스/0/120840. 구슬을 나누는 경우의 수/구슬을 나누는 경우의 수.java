class Solution {
    public int solution(int balls, int share) {
        return C(balls, share);
    }
    private int C(int n, int r) {
        if(r==0 || n==r) return 1;
        return C(n-1, r-1) + C(n-1, r);
    }
}