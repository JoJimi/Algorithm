import java.util.*;

class Solution {
    public int[] solution(String s) {
        HashSet<String> set = new HashSet<>();
        String[] str = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(str, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        
        int[] answer = new int[str.length];
        int idx = 0;
        for(String s1 : str) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) {
                    answer[idx++] = Integer.parseInt(s2);
                }
            }
        }
        
        return answer;
    }
}