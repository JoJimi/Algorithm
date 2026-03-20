class Solution
{
    public int solution(int n, int a, int b)
    {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        
        while(true) {
            if(min <= n/2 && max > n/2){
                break;
            }
            else {
                n /= 2;
                if(min > n) {
                    min -= n;
                    max -= n;
                }
            }
        }
        int count = 0;
        while(n > 1) {
            n /= 2;
            count++;
        }

        return count;
    }
}