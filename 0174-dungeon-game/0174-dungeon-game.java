class Solution {
    int[][] dp;
    int m,n;
    public int calculateMinimumHP(int[][] dungeon) {
        m=dungeon.length;
        n=dungeon[0].length;
        dp=new int [m][n];
        for(int[] row: dp) Arrays.fill(row,Integer.MIN_VALUE);
        return f(dungeon,0,0);
    }
    int f(int[][] grid,int i, int j){
        if(i==m-1 && j==n-1 ) return Math.max(1,1-grid[i][j]);
        if(i>=m || j>=n) return Integer.MAX_VALUE;

        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];

        int down=f(grid,i+1,j);
        int right=f(grid,i,j+1);

        int need=Math.min(down,right);

        return dp[i][j]=Math.max(1,need-grid[i][j]);
    }
}