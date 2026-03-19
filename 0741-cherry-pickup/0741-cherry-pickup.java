class Solution {
    int[][][] dp;
    int n;
    public int cherryPickup(int[][] grid) {
        n=grid.length;
        dp=new int[n][n][n];
        for(int[][] row:dp) {
            for(int[] col:row) Arrays.fill(col,Integer.MIN_VALUE);
        }
        return Math.max(0,dfs(grid,0,0,0));
    }
    int dfs(int[][] grid, int r1,int c1, int r2 ){
        int c2=r1+c1-r2;
        if(r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1]==-1 || grid[r2][c2]==-1){
            return Integer.MIN_VALUE;
        }
        if(r1==n-1 && c1==n-1) return grid[r1][c1];

        if(dp[r1][c1][r2]!=Integer.MIN_VALUE) return dp[r1][c1][r2];

        int cherries=grid[r1][c1];
        if(r1!=r2) cherries+=grid[r2][c2];

        int best=Math.max(
            Math.max(dfs(grid,r1+1,c1,r2+1),dfs(grid,r1+1,c1,r2)),
            Math.max(dfs(grid,r1,c1+1,r2+1),dfs(grid,r1,c1+1,r2))
        );
        return dp[r1][c1][r2]=cherries+best;
    }
}