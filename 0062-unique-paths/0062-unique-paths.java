class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int[] row:dp) Arrays.fill(row,-1);

        return func(0,0,m,n);
    }
    int func(int i, int j, int m  , int n ){
        if(i==m-1 && j==n-1) return 1;
        if(i>=m || j>=n) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int down=func(i+1,j,m,n);
        int right=func(i,j+1,m,n);

        return dp[i][j]=right+down;
    }
}