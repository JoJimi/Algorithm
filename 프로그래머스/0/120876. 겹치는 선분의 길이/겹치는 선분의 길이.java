class Solution {
    public int solution(int[][] lines) {
        int[] arr = new int[201]; // -100 ~ 100 대응
        
        for(int[] line : lines) {
            int start = line[0];
            int end = line[1];
            
            for(int i = start; i < end; i++) {
                arr[i + 100]++;
            }
        }
        
        int answer = 0;
        
        for(int count : arr) {
            if(count >= 2) {
                answer++;
            }
        }
        
        return answer;
    }
}