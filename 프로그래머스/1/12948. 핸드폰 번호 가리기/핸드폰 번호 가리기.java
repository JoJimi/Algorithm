class Solution {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();

        // 뒤 4자리를 제외한 부분을 *
        for (int i = 0; i < phone_number.length() - 4; i++) {
            answer.append("*");
        }

        // 뒤 4자리는 그대로 추가
        answer.append(phone_number.substring(phone_number.length() - 4));

        return answer.toString();
    }
}