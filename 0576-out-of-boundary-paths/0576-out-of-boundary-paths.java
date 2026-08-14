class Solution {
    Integer[][][] dp;
    int mod=1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new Integer[m][n][maxMove+1];

        return dfs(startRow,startColumn,m,n,0,maxMove);
    }
    int dfs(int i, int j, int m , int n, int currMove, int maxMove){
        if(currMove>maxMove) return 0;

        if(i<0 || j<0 || i>=m || j>=n) return 1;

        if(dp[i][j][currMove]!=null) return dp[i][j][currMove];

        int top=dfs(i-1,j,m,n,currMove+1,maxMove);
        int down=dfs(i+1,j,m,n,currMove+1,maxMove);
        int left=dfs(i,j-1,m,n,currMove+1,maxMove);
        int right=dfs(i,j+1,m,n,currMove+1,maxMove);

        return dp[i][j][currMove]=(int)(((long)top+down+left+right)%mod);
    }
}