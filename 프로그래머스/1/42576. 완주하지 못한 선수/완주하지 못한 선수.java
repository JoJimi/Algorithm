import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        String str = "";
        for(int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                str = participant[i];
                break;
            }
        }
        if("".equals(str)) return participant[participant.length - 1];
        else return str;
        
    }
}