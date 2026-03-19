class Solution {
    int r;
    int c;
    int[][][] dp;
//     public int cherryPickup(int[][] grid) {
//         r=grid.length;
//         c=grid[0].length;
//         dp=new int[r][c][c];
//         for(int[][] row:dp){
//             for(int[] col : row) Arrays.fill(col,-1);
//         }
//         return f(grid,0,0,c-1);
//     }
//     int f(int[][] grid, int r1 ,int c1 , int c2){
//         if(c1<0 || c2<0 || c1>=c || c2>=c) return Integer.MIN_VALUE;

//         if(r1==r-1) {
//             if(c1==c2) return grid[r1][c1];
//             else return grid[r1][c1]+grid[r1][c2];
//         }
//         if(dp[r1][c1][c2]!=-1) return dp[r1][c1][c2];

//         int max=Integer.MIN_VALUE;

//         for(int i=-1;i<=1;i++){
//             for(int j=-1;j<=1;j++){
//                 int value=0;
//                 int next=f(grid,r1+1,c1+i,c2+j);

//                 if(next==Integer.MIN_VALUE) continue;
//                 if(c1==c2) value=grid[r1][c1];
//                 else value=grid[r1][c1]+grid[r1][c2];

//                 value+=next;
//                 max=Math.max(max,value);
//             }
//         }
//         return dp[r1][c1][c2]=max;
//     }

    public int cherryPickup(int[][] grid){
        r=grid.length;
        c=grid[0].length;
        dp=new int[r][c][c];
        for(int[][] row:dp){
            for(int[] col : row) Arrays.fill(col,-1);
        }
        for(int c1=0;c1<c;c1++){
            for(int c2=0;c2<c;c2++){
                if(c1==c2) dp[r-1][c1][c2]=grid[r-1][c1];
                else dp[r-1][c1][c2]=grid[r-1][c1]+grid[r-1][c2];
            }
        }
        for(int i=r-2;i>=0;i--){
            for(int j1=0;j1<c;j1++){
                for(int j2=0;j2<c;j2++){
                    int max=Integer.MIN_VALUE;
                    for(int dj1=-1;dj1<=1;dj1++){
                        for(int dj2=-1;dj2<=1;dj2++){
                            int value=0;

                            if(j1==j2) value=grid[i][j1];
                            else value=grid[i][j1]+grid[i][j2];

                            if(j1+dj1>=0 && j1+dj1<c && j2+dj2>=0 && j2+dj2<c) value+=dp[i+1][j1+dj1][j2+dj2];
                            else continue;
                            max=Math.max(max,value);
                        }
                    }
                    dp[i][j1][j2]=max;
                }
            }
        }
        return dp[0][0][c-1];
    }
}