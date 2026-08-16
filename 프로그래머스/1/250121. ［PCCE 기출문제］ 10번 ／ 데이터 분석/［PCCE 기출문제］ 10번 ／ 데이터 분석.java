import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        // 각 정보에 해당하는 인덱스
        Map<String, Integer> index = new HashMap<>();
        index.put("code", 0);
        index.put("date", 1);
        index.put("maximum", 2);
        index.put("remain", 3);
        
        int extIndex = index.get(ext);
        int sortIndex = index.get(sort_by);
        
        // 조건에 맞는 데이터만 필터링
        List<int[]> result = new ArrayList<>();
        
        for (int[] row : data) {
            if (row[extIndex] < val_ext) {
                result.add(row);
            }
        }
        
        // sort_by 기준 오름차순 정렬
        result.sort((a, b) -> Integer.compare(a[sortIndex], b[sortIndex]));
        
        // List<int[]> -> int[][]
        return result.toArray(new int[result.size()][]);
    }
}