class Solution {
    Integer[] dp;
    public String stoneGameIII(int[] stoneValue) {
        dp=new Integer[stoneValue.length];
        int result=func(stoneValue,0);
        if(result>0) return "Alice";
        else if(result<0) return "Bob";
        else return "Tie";
    }
    int func(int[] nums, int i){
        if(i==nums.length) return 0;

        if(dp[i]!=null) return dp[i];

        int result=nums[i]-func(nums,i+1);
        if(i+1<nums.length) result=Math.max(result,nums[i]+nums[i+1]-func(nums,i+2));
        if(i+2<nums.length) result=Math.max(result,nums[i]+nums[i+1]+nums[i+2]-func(nums,i+3));

        return dp[i]=result;
    }
}