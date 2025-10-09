import java.util.*;

class Solution {
    private static final int[] PERCENT = {10, 20, 30, 40};
    private static int bestSub = 0;
    private static int bestPrice = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int sub = 0;
        int price = 0;
        int[] emoticon = new int[emoticons.length];
        
        dfs(0, users, emoticons, emoticon);
        
        int[] answer = {bestSub, bestPrice};
        return answer;
    }
    public void dfs(int idx, int[][] users, int[] emoticons, int[] emoticon){
        if(idx == emoticons.length){
            evaluate(users, emoticons, emoticon);
            return;
        }
        for(int p : PERCENT){
            emoticon[idx] = p;
            dfs(idx + 1, users, emoticons, emoticon);
        }
    }
    public void evaluate(int[][] users, int[] emoticons, int[] emoticon){
        int sub = 0;
        int price = 0;
        
        for(int[] user: users){
            int total = 0;
            
            for(int j = 0; j < emoticon.length; j++){
                if(user[0] <= emoticon[j]){
                    total = total + emoticons[j] * (100 - emoticon[j]) / 100;
                }
            }
            
            if(user[1] <= total) sub++;
            else price += total;
        }
        
        
        if(sub > bestSub){
            bestSub = sub;
            bestPrice = price;
        }
        else if(sub == bestSub && price > bestPrice){
            bestPrice = price;
        }
        
    }
}