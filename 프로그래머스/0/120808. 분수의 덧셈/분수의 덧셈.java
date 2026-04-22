class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int sumN = numer1*denom2 + numer2*denom1;
        int sumD = denom1*denom2;
        // 최대공약수 구하기
        int min = sumN > sumD ? sumD : sumN;
        int gcd = 1;
        for (int i = min; i > 1; i--) {
            if(sumN%i + sumD%i == 0) {
                gcd = i;
                break;
            }
        }
        int[] answer = { sumN/gcd, sumD/gcd };
        return answer;
    }
}