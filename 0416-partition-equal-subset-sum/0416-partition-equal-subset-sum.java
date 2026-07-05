class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n:nums) sum+=n;

        if(sum%2!=0) return false;

        dp= new Boolean[nums.length][sum/2+1];

        return func(nums,0,sum/2);
    }
    boolean func(int[] nums, int index ,int target){
        if(index==nums.length && target==0) return true;

        if(index == nums.length && target!=0) return false;
        if(dp[index][target]!=null) return dp[index][target];

        boolean take=false;
        if(target-nums[index]>=0) take=func(nums,index+1,target-nums[index]);
        boolean notTake=func(nums,index+1,target);

        return dp[index][target]=take||notTake;
    }
}