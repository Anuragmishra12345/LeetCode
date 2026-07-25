class Solution {
    // int[][] dp;
    // public int maximalSquare(char[][] matrix) {
    //     dp=new int[matrix.length][matrix[0].length];
    //     for(int[] row:dp) Arrays.fill(row,-1);

    //     int max=0;

    //     for(int i=0;i<matrix.length;i++){
    //         for(int j=0;j<matrix[0].length;j++){
    //             if(matrix[i][j]=='1') max=Math.max(max,func(matrix,i,j));
    //         }
    //     }
    //     return max*max;
    // }
    // int func(char[][] matrix, int i , int j) {
    //     if(i==matrix.length || j==matrix[0].length) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];

    //     if(matrix[i][j]=='0') return 0;

    //     int right=func(matrix,i,j+1);
    //     int down=func(matrix,i+1,j);
    //     int diag=func(matrix,i+1,j+1);

    //     return dp[i][j]=1+Math.min(right,Math.min(down,diag));
    // }

    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int[][] dp=new int[m+1][n+1];

        int maxArea=0;

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]=='1'){
                    dp[i][j]=1+Math.min(dp[i][j+1],Math.min(dp[i+1][j],dp[i+1][j+1]));

                    maxArea=Math.max(maxArea,dp[i][j]);
                }
            }
        }
        return maxArea*maxArea;
    }
}