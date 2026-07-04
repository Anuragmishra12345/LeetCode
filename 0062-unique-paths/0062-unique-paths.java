class Solution {
    // int[][] dp;
    // public int uniquePaths(int m, int n) {
    //     dp=new int[m][n];
        
    //     for(int[] row:dp) Arrays.fill(row,-1);

    //     return func(m,n,0,0);
    // }
    // int func(int m , int n, int i, int j){
    //     if(i==m-1 && j==n-1) return 1;
        
    //     if(dp[i][j]!=-1) return dp[i][j];

    //     int bottom=0;
    //     int right=0;
    //     if(i+1<m) bottom=func(m,n,i+1,j);
    //     if(j+1<n) right=func(m,n,i,j+1);

    //     return dp[i][j]=bottom+right;
    // }

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        dp[m-1][n-1]=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1) continue;
                int bottom=0;
                int right=0;
                if(i+1<=m-1) bottom=dp[i+1][j];
                if(j+1<n) right=dp[i][j+1];
                dp[i][j]=bottom+right;
            }
        }
        return dp[0][0];
    }
}