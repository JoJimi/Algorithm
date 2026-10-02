import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        int[][] distance = new int[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{0, 0});
        distance[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] pol = q.poll();
            int x = pol[0];
            int y = pol[1];
            
            if(x == n-1 && y == m-1) return distance[x][y];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(maps[nx][ny] == 0) continue;
                if(distance[nx][ny] != 0) continue;
                
                
                distance[nx][ny] = distance[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        return -1;
    }
}