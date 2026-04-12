class Solution {
    int n;
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        n=nums.length;
        dp=new int[n][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(nums,0,-1);
    }
    int f(int[] nums, int i, int j){
        if(i==n) return 0;
        if(dp[i][j+1]!=-1) return dp[i][j+1];

        int len=f(nums,i+1,j);
        if(j==-1 || nums[i]>nums[j]) len=Math.max(len,1+f(nums,i+1,i));

        return dp[i][j+1]=len;
    }
}