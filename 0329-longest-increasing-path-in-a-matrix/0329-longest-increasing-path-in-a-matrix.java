class Solution {
    int m;
    int n;
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        m=matrix.length;
        n=matrix[0].length;

        dp=new int[m][n];

        for(int[] d:dp) Arrays.fill(d,-1);

        int result=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result=Math.max(result,1+dfs(matrix,i,j));
            }
        }
        return result;
    }
    int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    private int dfs(int[][] matrix, int i, int j){

        if(dp[i][j]!=-1) return dp[i][j];
        int result=0;
        for(int[] d:dir){
            int r=i+d[0];
            int c=j+d[1];

            if(r<m && r>=0 && c<n && c>=0 && matrix[r][c]>matrix[i][j]){
                result=Math.max(result,1+dfs(matrix,r,c));
            }
        }
        return dp[i][j]=result;
    }
}