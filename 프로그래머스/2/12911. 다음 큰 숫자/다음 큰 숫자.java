class Solution {
    public int solution(int n) {
        int answer = n;
        
        int num = n;
        int oneCount = 0;
        while(num > 0) {
            int temp = num % 2;
            num /= 2;
            
            if(temp == 1) oneCount++;
        }
        
        while(true) {
            int count = 0;
            answer++;
            
            int a = answer;
            while(a > 0) {
                int temp = a % 2;
                a /= 2;
            
                if(temp == 1) count++;
            }
            
            if(count == oneCount) {
                break;
            }
        }
        
        return answer;
    }
}