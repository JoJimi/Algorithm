class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int count1 = 0, count2 = 0;
        
        if(a >= b) {
            count1 = b;
            count2 = a;
        }
        else {
            count1 = a;
            count2 = b;
        }
        for(int i = count1; i <= count2; i++) {
            answer += i;
        }
        
        return answer;
    }
}