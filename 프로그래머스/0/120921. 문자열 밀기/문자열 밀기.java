class Solution {
    public int solution(String A, String B) {

        if (A.equals(B)) {
            return 0;
        }

        String str = A;

        for (int i = 1; i <= A.length(); i++) {

            // 오른쪽으로 한 칸 밀기
            str = str.charAt(str.length() - 1)
                    + str.substring(0, str.length() - 1);

            if (str.equals(B)) {
                return i;
            }
        }

        return -1;
    }
}