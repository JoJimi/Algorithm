class Solution {
    public int solution(int[] wallet, int[] bill) {
        int count = 0;
        int[] size = bill;
        
        while(true) {
            if(judge(wallet, size)) break;      // 지갑에 넣을 수 있으면 break;
            
            // 큰 값을 반으로 접는다. (홀수면 버림처리)
            if(size[0] < size[1]) size[1] /= 2;     
            else size[0] /= 2;
            
            count++;    // 접은 횟수 추가
        }
        
        return count;
    }
    // 지갑 안에 지폐를 넣을 수 있는지 확인하는 메서드
    private boolean judge(int[] wallet, int[] size) {   
        if(wallet[0] >= size[0] && wallet[1] >= size[1]) return true;
        else if(wallet[0] >= size[1] && wallet[1] >= size[0]) return true;
        else return false;
    }
}