class Solution {
    public int[] solution(int[] arr) {
        // 배열의 길이가 1이면 제거 후 빈 배열이 되므로 -1 반환
        if (arr.length == 1) {
            return new int[]{-1};
        }

        // 가장 작은 값 찾기
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // 가장 작은 값을 제외한 배열 생성
        int[] answer = new int[arr.length - 1];
        int index = 0;

        for (int num : arr) {
            if (num != min) {
                answer[index++] = num;
            }
        }

        return answer;
    }
}