class Solution {
    // int[][] dp;
    // public int rob(int[] nums) {
    //     dp=new int[nums.length][2];
    //     for(int[] row:dp) Arrays.fill(row,-1);
    //     return func(nums,nums.length-1,0);
    // } 
    // int func(int[] nums, int index,int prev){
    //     if(index<0) return 0;

    //     if(dp[index][prev]!=-1) return dp[index][prev];

    //     int take=0;
    //     if(prev==0) take=nums[index]+func(nums,index-1,1);
    //     int notTake=func(nums,index-1,0);

    //     return dp[index][prev]=Math.max(take,notTake);
    // }

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