import java.util.*;

class Solution {
    ArrayList<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        
        int[][] answer = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        
        return answer;
    }
    private void hanoi(int n, int from, int mid, int to){
        if(n == 1) {
            list.add(new int[]{from, to});
            return;
        }
        
        hanoi(n-1, from, to, mid);
        list.add(new int[]{from, to});
        hanoi(n-1, mid, from, to);
    }
}