import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        
        List<String> lists = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            sb.append(ch);
            if(ch == '}') {
                lists.add(sb.toString());
                sb = new StringBuilder();
                i++;
            }        
        }       
        Map<Integer, Integer> map = new HashMap<>();
        while(true) {
            if(lists.size() == 0) break;
            String str = lists.remove(0);
            String[] sArr = str.substring(1, str.length() - 1).split(",");
            
            for(int i = 0; i < sArr.length; i++) {
                int n = Integer.parseInt(sArr[i]);
                map.put(n, map.getOrDefault(n, 0) + 1);
                
            }
        }
        
        List<Integer> keys = map.entrySet().stream()
            .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        int[] answer = new int[keys.size()];
        for(int i = 0; i < keys.size(); i++) {
            answer[i] = keys.get(i);
        }
        
        return answer;
    }
}