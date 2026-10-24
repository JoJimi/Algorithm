class Solution {
    static int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return count;
    }
    public void dfs(int[] numbers, int index, int target, int sum) {
        if(index == numbers.length) {
            if(target == sum) {
                count++;
            }
            return;
        }
        
        dfs(numbers, index + 1, target, sum + numbers[index]);
        dfs(numbers, index + 1, target, sum - numbers[index]);
        
    }
}