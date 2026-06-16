class Solution {
    Long[][] dp;
    public long rob(int[] nums, int[] colors) {
        dp=new Long[nums.length][2];
        return dfs(nums,colors,nums.length-1,0);
    }
    long dfs(int[] nums, int[] colors, int index, int color){
        if(index<0) return 0;

        if(dp[index][color]!=null) return dp[index][color];

        long notTake=dfs(nums, colors,index-1,0);
        long take=0;
        boolean taken = true;
        if(index<nums.length-1 && color ==1 && colors[index]==colors[index+1]){
            taken=false;
        }
        if(taken) take=nums[index]+dfs(nums,colors,index-1,1);

        return dp[index][color]=Math.max(take,notTake);
    }
}