import java.util.*;

class Solution {
    static int count = Integer.MAX_VALUE;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        bfs(maps);        
        if(count == Integer.MAX_VALUE) count = -1;
        return count;
    }
    public void bfs(int[][] maps){        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] pol = q.poll();
            
            
            if(pol[0] == n-1 && pol[1] == m-1) {
                count = Math.min(count, pol[2]);
                return;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = pol[0] + dx[i];
                int ny = pol[1] + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny] || maps[nx][ny] == 0) continue;
                
                q.add(new int[]{nx, ny, pol[2] + 1});
                visited[nx][ny] = true;
            }
        }
        
    }
}