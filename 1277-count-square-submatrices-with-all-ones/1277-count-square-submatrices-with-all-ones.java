class Solution {
    int[][] dp;

    public int countSquares(int[][] matrix) {
        dp=new int[matrix.length][matrix[0].length];
        for(int[] d:dp) Arrays.fill(d,-1);

        int ans=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1) {
                    int length=solver(matrix,i,j);
                    while(length>0){
                        ans++;
                        length--;
                    }
                }
            }
        }
        return ans;
    }
    int solver (int[][] matrix ,int i, int j){
        if(i>=matrix.length || i<0 || j>=matrix[0].length || j<0 || matrix[i][j]==0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int top=solver(matrix,i-1,j);
        int right=solver(matrix,i,j+1);
        int diagonal=solver(matrix,i-1,j+1);

        return dp[i][j]=1+Math.min(top,Math.min(right,diagonal));
    }
}