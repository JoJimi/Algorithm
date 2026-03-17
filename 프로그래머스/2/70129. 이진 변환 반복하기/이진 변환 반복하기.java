class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String str = s;
        int res1 = 0, res2 = 0;
        
        while(true) {
            if(str.length() == 1) break;
            
            int count = 0;
            
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                
                if(ch == '1') {
                    count++;
                }
                else {
                    res2++;
                }
            }
            StringBuilder sb = new StringBuilder();
            
            while(count > 0){
                int temp = count % 2;
                sb.append(String.valueOf(temp));

                count /= 2;
            }

            str = sb.reverse().toString();
            res1++;
        }
        
        answer[0] = res1;
        answer[1] = res2;
        
        return answer;
    }
}