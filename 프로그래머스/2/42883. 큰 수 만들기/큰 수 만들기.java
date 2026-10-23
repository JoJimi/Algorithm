class Solution {
    public String solution(String number, int k) {        
        /**
         * 어차피 숫자는 0~9이다.
         * 앞, 뒤 숫자 비교해서 뒤가 더 크면 앞의 숫자를 없애는 방식.
         */
        int count = k;
        boolean[] judge = new boolean[number.length()];
        
        int start = 1;
        while(start < number.length()) {
            if(count <= 0) break;
            for(int i = 1; i <= start; i++) {
                if(judge[start - i]) continue;
                if(number.charAt(start - i) < number.charAt(start)){
                    judge[start - i] = true;
                    count--;
                }
                else break;
                
                if(count <= 0) break;
            }
            start++;            
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number.length(); i++) {
            if(!judge[i]) sb.append(number.charAt(i));
        }
        if(sb.toString().length() != number.length() - k) {
            sb = new StringBuilder();
            for(int i = 0; i < number.length() - k; i++) {
                sb.append(number.charAt(i));
            }
        }
        
        return sb.toString();
    }
}