class Solution {
    // int[][] dp;
    // public int uniquePaths(int m, int n) {
    //     dp=new int[m][n];
    //     for(int[] row:dp) Arrays.fill(row,-1);

    //     return func(0,0,m,n);
    // }
    // int func(int i, int j, int m  , int n ){
    //     if(i==m-1 && j==n-1) return 1;
    //     if(i>=m || j>=n) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];

    //     int down=func(i+1,j,m,n);
    //     int right=func(i,j+1,m,n);

    //     return dp[i][j]=right+down;
    // }

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        dp[m-1][n-1]=1;

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1) continue;

                int down=dp[i+1][j];
                int right=dp[i][j+1];

                dp[i][j]=right+down;
            }
        }
        return dp[0][0];
    }
}