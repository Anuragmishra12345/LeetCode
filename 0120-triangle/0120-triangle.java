class Solution {
    int r;
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        r=triangle.size();
        dp=new int[r][r];
        for(int[] row:dp) Arrays.fill(row, Integer.MIN_VALUE);
        return dfs(triangle,0,0);
    }
    int dfs(List<List<Integer>> triangle, int i, int j){
        if(i==r-1) return triangle.get(i).get(j);

        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];

        int down=dfs(triangle,i+1,j);
        int right=dfs(triangle,i+1,j+1);

        return dp[i][j]=triangle.get(i).get(j)+Math.min(down,right);
    }
}