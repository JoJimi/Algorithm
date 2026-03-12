class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        int num = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            answer = num * arr[i] / lcm(num, arr[i]);
            num = answer;
        }
        
        return answer;
    }
    
    private int lcm(int num1, int num2) {
        while(num2 != 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        
        return num1;
    }   
}