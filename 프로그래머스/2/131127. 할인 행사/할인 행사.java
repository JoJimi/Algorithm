class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        int[] count = new int[number.length];
        
        for(int i = 0; i < discount.length; i++) {      // 100000
            for(int j = 0; j < count.length; j++) {
                count[j] = number[j];
            }
            
            for(int j = 0; j < 10; j++) {               // 10
                for(int w = 0; w < want.length; w++){   // 10
                    if(i+j >= discount.length) break;
                    if(want[w].equals(discount[i+j])) {
                        count[w]--;
                        break;
                    }
                }
            }
            
            int c = 0;
            for(int j = 0; j < count.length; j++) {                
                if(count[j] > 0) break;
                else c++;
            }
            
            if(c == count.length) result++;
        }
        
        return result;
    }
}