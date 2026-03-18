class Solution {
    int r,c;
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int[]row: dp) Arrays.fill(row,-1);
        r=m;c=n;
        return dfs(0,0);
    }
    int dfs(int i, int j){
        if(i==r-1 && j==c-1) return 1;
        if(i>=r || j>=c) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int right=dfs(i,j+1);
        int down=dfs(i+1,j);
        return dp[i][j]=right+down;
    }
}