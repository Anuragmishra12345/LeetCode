class Solution {
    int m;
    int n;
    int MOD=1000000007;
    int[][] dp;
    public int uniquePaths(int[][] grid) {
        m=grid.length;
        n=grid[0].length;

        dp=new int[m][n];

        for(int[] d:dp) Arrays.fill(d,-1);

        return dfs(grid,0,0);
    }

    int dfs(int[][] grid, int i, int j){
        if(i>=m || j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;

        if(dp[i][j]!=-1) return dp[i][j];

        long right=move(grid,i,j+1,true);
        long down=move(grid,i+1,j,false);

        return dp[i][j]=(int)((right+down)%MOD);
    }

    int move(int[][] grid, int r, int c, boolean movingRight){

        while(r<m && c<n && grid[r][c]==1){
            if(movingRight){
                r++;
                movingRight=false;
            }
            else{
                c++;
                movingRight=true;
            }
        }

        return (r>=m || c>=n)?0:dfs(grid,r,c);
    }
}