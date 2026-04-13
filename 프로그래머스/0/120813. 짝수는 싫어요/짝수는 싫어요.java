class Solution {
    public int[] solution(int n) {
        int index = 0, size = n/2;
        if(n % 2 == 1) {
            size++;
        }
        int[] answer = new int[size];
        
        for(int i = 1; i <= n; i++) {
            if(i % 2 == 1){
                answer[index] = i;
                index++;
            } 
        }
        
        return answer;
    }
}