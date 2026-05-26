class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] arr = quiz[i].split(" ");

            int x = Integer.parseInt(arr[0]);
            String op = arr[1];
            int y = Integer.parseInt(arr[2]);
            int z = Integer.parseInt(arr[4]);

            int result = 0;

            if (op.equals("+")) {
                result = x + y;
            } else {
                result = x - y;
            }

            answer[i] = (result == z) ? "O" : "X";
        }

        return answer;
    }
}