class Solution {
    public String solution(String polynomial) {
        String[] terms = polynomial.split(" \\+ ");
        
        int xSum = 0;
        int numSum = 0;
        
        for (String term : terms) {
            if (term.contains("x")) {
                if (term.equals("x")) {
                    xSum += 1;
                } else {
                    xSum += Integer.parseInt(term.replace("x", ""));
                }
            } else {
                numSum += Integer.parseInt(term);
            }
        }
        
        StringBuilder answer = new StringBuilder();
        
        // x항 처리
        if (xSum > 0) {
            if (xSum == 1) {
                answer.append("x");
            } else {
                answer.append(xSum).append("x");
            }
        }
        
        // 상수항 처리
        if (numSum > 0) {
            if (answer.length() > 0) {
                answer.append(" + ");
            }
            answer.append(numSum);
        }
        
        return answer.toString();
    }
}