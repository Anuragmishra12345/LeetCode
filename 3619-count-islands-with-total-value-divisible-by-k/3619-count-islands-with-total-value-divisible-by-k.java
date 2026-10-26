class Solution {
    int m;
    int n;
    public int countIslands(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        int count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) continue;

                if(dfs(grid,i,j)%k==0) count++;
            }
        }
        return count;
    }
    int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
    long dfs(int[][] grid, int i , int j){
        long value=grid[i][j];
        grid[i][j]=0;
        for(int[] d:dir){
            int r=i+d[0];
            int c=j+d[1];

            if(r>=m || r<0 || c>=n || c<0 || grid[r][c]==0) continue;

            value+=dfs(grid,r,c);
        }
        return value;
    }
}