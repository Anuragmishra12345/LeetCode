class Solution {
    int m;
    int n;
    boolean[][][] dp;
    public int minCost(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        dp=new boolean[m][n][1024];
        dfs(grid,0,0,0);

        for(int x=0;x<1024;x++){
            if(dp[m-1][n-1][x]) return x;
        }

        return -1;
    }
    void dfs(int[][] grid, int i, int j,int xor){
        xor^=grid[i][j];

        if (dp[i][j][xor]) return;

        dp[i][j][xor]=true;


        if(j+1<n) dfs(grid,i,j+1,xor);

        if(i+1<m) dfs(grid,i+1,j,xor);
    }
}