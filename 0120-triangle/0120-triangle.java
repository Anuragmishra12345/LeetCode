class Solution {
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int r=triangle.size();
        dp=new int[r][r];
        for(int[] row:dp) Arrays.fill(row,Integer.MIN_VALUE);
        return func(triangle,0,0);
    }
    int func(List<List<Integer>> triangle , int i, int j){
        if(i==triangle.size()-1) return triangle.get(i).get(j);

        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];

        return dp[i][j]=triangle.get(i).get(j)+Math.min(func(triangle,i+1,j),func(triangle,i+1,j+1));
    }
}