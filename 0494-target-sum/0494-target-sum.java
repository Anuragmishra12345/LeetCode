class Solution {
    int[][] dp;
    int sum=0;
    public int findTargetSumWays(int[] nums, int target) {
        for(int n:nums) sum+=n;
        dp=new int[nums.length][2*sum+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return dfs(nums,target,0);
    }
    int dfs(int[] nums, int target, int index){
        if (target < -sum || target > sum) return 0;

        if(index == nums.length){
            return target == 0 ? 1 : 0;
        }

        if(dp[index][target+sum]!=-1) return dp[index][target+sum];

        int negative=dfs(nums,target+nums[index],index+1);
        int positive=dfs(nums,target-nums[index],index+1);

        return dp[index][target+sum]=negative+positive;
    }
}