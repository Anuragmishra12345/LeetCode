class Solution {
    int m,n;
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public int numEnclaves(int[][] grid) {
        int ans=0;
        m=grid.length;
        n=grid[0].length;
        boolean[][] visited =new boolean[m][n];
        for(int i=0; i<m;i++){
            dfs(grid,i,0,visited);
            dfs(grid,i,n-1,visited);
        }
        for(int j=0;j<n;j++){
            dfs(grid,0,j,visited);
            dfs(grid,m-1,j,visited);
        }
        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]==1) ans++;
            }
        }
        return ans;
    }
    void dfs(int[][] grid,int r, int c, boolean[][] visited){
        if(grid[r][c]==0 || visited[r][c]) return;

        visited[r][c]=true;

        for(int[] d:dirs){
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1) dfs(grid,nr,nc,visited);
        }
    }
}