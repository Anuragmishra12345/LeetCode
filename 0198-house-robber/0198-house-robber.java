class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][2];

        for(int i=1;i<=n;i++){
            dp[i][0]=Math.max(nums[i-1]+dp[i-1][1],dp[i-1][0]);

            dp[i][1]=dp[i-1][0];
        }
        return dp[n][0];
    }
}