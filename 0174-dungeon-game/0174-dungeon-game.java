class Solution {
    // int[][] dp;
    // public int calculateMinimumHP(int[][] dungeon) {
    //     dp=new int[dungeon.length][dungeon[0].length];
    //     for(int[] row:dp) Arrays.fill(row,Integer.MIN_VALUE);
    //     return func(dungeon,0,0);
    // }
    // int func(int[][] grid, int i, int j){
    //     if(i==grid.length-1 && j==grid[0].length-1) return Math.max(1,1-grid[i][j]);
    //     if(i>=grid.length || j>=grid[0].length) return Integer.MAX_VALUE;

    //     if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];

    //     int right=func(grid,i,j+1);
    //     int down=func(grid,i+1,j);

    //     int need=Math.min(right,down);

    //     return dp[i][j]=Math.max(1,need-grid[i][j]);
    // }

    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        int[][] dp=new int[m+1][n+1];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
                        
        dp[m][n-1]=1;
        dp[m-1][n]=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int right=dp[i][j+1];
                int down=dp[i+1][j];

                int need=Math.min(right,down);

                dp[i][j]=Math.max(1,need-dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}