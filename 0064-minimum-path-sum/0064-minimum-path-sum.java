class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        dp=new int[grid.length][grid[0].length];
        for(int[] row:dp) Arrays.fill(row,-1);

        return func(grid,0,0);
    }
    int func(int[][] grid, int i, int j){
        if(i==grid.length-1 && j==grid[0].length-1) return grid[i][j];
        if(i>=grid.length || j>=grid[0].length) return Integer.MAX_VALUE;

        if(dp[i][j]!=-1) return dp[i][j];

        int down=func(grid,i+1,j);
        if(down!=Integer.MAX_VALUE) down+=grid[i][j];
        int right=func(grid,i,j+1);
        if(right!=Integer.MAX_VALUE) right+=grid[i][j];

        return dp[i][j]=Math.min(right,down);
    }
}