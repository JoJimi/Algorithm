class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        int n1 = denom2 * numer1 + denom1 * numer2;
        int n2 = denom1 * denom2;
        
        int g = gcd(n1, n2);
        
        answer[0] = n1 / g;
        answer[1] = n2 / g;
        
        return answer;
    }
    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}