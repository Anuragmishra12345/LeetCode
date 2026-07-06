class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        int maxArea=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int top=(i-1>=0)?dp[i-1][j]:0;
                int left=(j-1>=0)?dp[i][j-1]:0;
                int diag=(i-1>=0 && j-1>=0)?dp[i-1][j-1]:0;

                if(matrix[i][j]=='1'){
                    dp[i][j]=1+Math.min(top,Math.min(left,diag));
                    maxArea=Math.max(maxArea,dp[i][j]);
                }
            }
        }
        return maxArea*maxArea;
    }
}