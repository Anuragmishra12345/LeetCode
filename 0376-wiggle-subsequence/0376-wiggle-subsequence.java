class Solution {
    Integer[][] dp;
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==1) return 1;
        dp=new Integer[nums.length+1][3];
        return 1+solve(nums,0,0);
    }
    int solve(int[] nums, int index, int sign){
        if(index==nums.length) return 1;

        if(dp[index][sign]!=null) return dp[index][sign];

        int ans=0;
        for(int i=index+1;i<nums.length;i++){
            int newSign=0;
            if(nums[i]>nums[index]) newSign=1;
            else if(nums[i]<nums[index]) newSign =2;
            else continue;

            if(sign==0){
                ans=Math.max(ans,1+solve(nums,i,newSign));
            }
            else if(sign ==1 && newSign==2) {
                ans=Math.max(ans,1+solve(nums,i,newSign));
            }
            else if(sign==2 && newSign==1){
                ans=Math.max(ans,1+solve(nums,i,newSign));
            }
        }
        return dp[index][sign]=ans;
    }
}