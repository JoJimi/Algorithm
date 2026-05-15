class Solution {
    public long solution(String numbers) {
        String[] english = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
        };
        
        for (int i = 0; i < english.length; i++) {
            numbers = numbers.replace(english[i], String.valueOf(i));
        }
        
        return Long.parseLong(numbers);
    }
}