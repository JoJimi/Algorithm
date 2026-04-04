class Solution {
    public int[] solution(int[] num_list) {        
        int countEven = 0, countOdd = 0;
        for(int num : num_list) {
            if(num % 2 == 0) countEven++;
            else countOdd++;
        }
        
        int[] ans = new int[2];
        ans[0] = countEven;
        ans[1] = countOdd;
        return ans;
    }
}