class Solution {
    static int networkCount = 0;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 0) continue;
                if(i == j) continue;
                if(visited[i] && visited[j]) continue;
                
                //System.out.println(i + " " + j + " " + computers[i][j]);
                dfs(computers, i, j);
                networkCount++;
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                System.out.println(i);
                networkCount++;
            }
        }
        
        return networkCount;
    }
    public static void dfs(int[][] computers, int x, int y) {
        if(visited[x] && visited[y]) return;
        visited[x] = true;
        visited[y] = true;
        
        for(int i = 0; i < computers.length; i++) {
            if(i == y || i == x) continue;
            if(computers[y][i] == 0) continue;
            
            System.out.println(x + " " + y + " " + i);
            dfs(computers, y, i);
        }
    }
}