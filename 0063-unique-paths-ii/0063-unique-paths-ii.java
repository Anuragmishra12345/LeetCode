class Solution {
    // int m;
    // int n;
    // int[][] dp;
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     m=obstacleGrid.length;
    //     n=obstacleGrid[0].length;
    //     if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1) return 0;
    //     dp=new int[m][n];
    //     for(int[] row:dp) Arrays.fill(row,-1);
    //     return func(obstacleGrid,0,0);
    // }
    // int func(int[][] obs, int i , int j){
    //     if(i==m-1 && j==n-1) return 1;
    //     if(i>=m || j>=n) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];

    //     int right=0;
    //     if(j+1<n && obs[i][j+1]!=1) right=func(obs, i ,j+1);

    //     int down=0;
    //     if(i+1<m && obs[i+1][j]!=1) down = func(obs,i+1,j);

    //     return dp[i][j]=right+down;
    // }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1) return 0;

        int[][] dp=new int[m][n];
        dp[m-1][n-1]=1;

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(obstacleGrid[i][j]==1) continue;
                if(i==m-1 && j==n-1) continue;
                int right=0;
                if(j+1<n && obstacleGrid[i][j+1]!=1) right=dp[i][j+1];

                int down=0;
                if(i+1<m && obstacleGrid[i+1][j]!=1) down=dp[i+1][j];

                dp[i][j]=right+down;
            }
        }
        return dp[0][0];
    }
}