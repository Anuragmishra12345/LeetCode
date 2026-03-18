class Solution {
    int r,c;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        // if(obstacleGrid[m-1][n-1]==1) return 0;
        r=m;
        c=n;
        int[][] dp=new int[m][n];
        for(int[] row:dp) Arrays.fill(row,-1);
        return dfs(obstacleGrid,0,0,dp);
    }
    int dfs(int[][] grid, int i, int j, int[][] dp){
        if(i>=r || j>=c || grid[i][j]==1) return 0;
        if(i==r-1 && j==c-1) return 1;

        if(dp[i][j]!=-1) return dp[i][j];
        int right=dfs(grid,i,j+1,dp);
        int down=dfs(grid,i+1,j,dp);
        return dp[i][j]=right+down;
    }
}