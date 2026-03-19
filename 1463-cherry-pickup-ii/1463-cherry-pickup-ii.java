class Solution {
    int r;
    int c;
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        r=grid.length;
        c=grid[0].length;
        dp=new int[r][c][c];
        for(int[][] row:dp){
            for(int[] col : row) Arrays.fill(col,-1);
        }
        return f(grid,0,0,c-1);
    }
    int f(int[][] grid, int r1 ,int c1 , int c2){
        if(c1<0 || c2<0 || c1>=c || c2>=c) return Integer.MIN_VALUE;

        if(r1==r-1) {
            if(c1==c2) return grid[r1][c1];
            else return grid[r1][c1]+grid[r1][c2];
        }
        if(dp[r1][c1][c2]!=-1) return dp[r1][c1][c2];
        int max=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int value=0;
                if(c1==c2) value=grid[r1][c1];
                else value=grid[r1][c1]+grid[r1][c2];
                value+=f(grid,r1+1,c1+i,c2+j);
                max=Math.max(max,value);
            }
        }
        return dp[r1][c1][c2]=max;
    }
}