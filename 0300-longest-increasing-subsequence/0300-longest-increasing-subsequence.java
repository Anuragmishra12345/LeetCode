class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp=new int[nums.length][nums.length+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return func(nums,0,-1);
    }
    int func(int[] nums, int index, int prev){
        if(index==nums.length) return 0;
        if(dp[index][prev+1]!=-1) return dp[index][prev+1];
        
        int len=func(nums,index+1,prev);
        if(prev==-1 || nums[index]>nums[prev]) len=Math.max(len,1+func(nums,index+1,index));

        return dp[index][prev+1]=len;
    }
}