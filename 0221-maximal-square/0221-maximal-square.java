class Solution {
    int m;
    int n;
    int[][] dp;
    public int maximalSquare(char[][] matrix) {
        m=matrix.length;
        n=matrix[0].length;
        dp=new int[m][n];
        for(int[] row:dp) Arrays.fill(row,-1);
    
        int max=0;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(matrix[row][col]=='1') {
                    max=Math.max(max,solve(matrix,row,col));
                }
            }
        }
        return max*max;
    }

    public int solve(char[][] matrix,int row, int col){
        if(row>=m || col>=n) return 0;
        if(dp[row][col]!=-1) return dp[row][col];
        
        if(matrix[row][col]=='0') return dp[row][col]=0;
        
        int right=solve(matrix,row,col+1);
        int down=solve(matrix,row+1,col);
        int diag=solve(matrix,row+1,col+1);

        return dp[row][col]=1+Math.min(right,Math.min(down,diag));
    }
}