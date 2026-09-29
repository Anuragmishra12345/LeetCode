class Solution {
    int m;
    int n;
    Boolean[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        if(grid[0][0]==')' || grid[m-1][n-1]=='(') return false;

        dp=new Boolean[m][n][m+n];

        return dfs(grid,0,0,1);
    }
    int[][] dir={{0,1},{1,0}};
    boolean dfs(char[][] grid , int i, int j, int status){
        if(i==m-1 && j==n-1){
            if(status==0) return true;
            else return false;
        }

        if(dp[i][j][status]!=null) return dp[i][j][status];
        boolean ans=false;
        for(int[] d:dir){
            int r=i+d[0];
            int c=j+d[1];

            if(r>=m || c>=n) continue;

            char type=grid[r][c];

            if(type=='(') {
                ans=ans || dfs(grid,r,c,status+1);
            }
            else{
                if(status>0){
                    ans=ans || dfs(grid,r,c,status-1);
                }
            }
        }
        return dp[i][j][status]=ans;
    }
}