class Solution {
    public long solution(int price, int money, int count) {
        long total = (long) price * count * (count + 1) / 2;
        
        if (total > money) {
            return total - money;
        }
        
        return 0;
    }
}

