class Solution {
    int[][] dp;
    int r,c;
    int min=Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        r=grid.length;
        c=grid[0].length;
        dp=new int[r][c];
        for(int[] row:dp) Arrays.fill(row,-1);
        return dfs(grid,0,0);
    }
    int dfs(int[][] grid, int i,int j){
        if(i>=r || j>=c) return Integer.MAX_VALUE;
        if(i==r-1 && j==c-1) return grid[i][j];

        if(dp[i][j]!=-1) return dp[i][j];

        int right=dfs(grid,i,j+1);
        int down=dfs(grid,i+1,j);
        
        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }
}