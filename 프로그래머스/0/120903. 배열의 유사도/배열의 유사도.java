class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        boolean[] visited = new boolean[s2.length];
        
        for(int i = 0; i < s1.length; i++) {
            for(int j = 0; j < s2.length; j++) {
                if(visited[j]) continue;
                if(s1[i].equals(s2[j])){
                    answer++;
                    visited[j] = true;
                }
            }
        }
        
        return answer;
    }
}