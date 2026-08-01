class Solution {
    int[][] dp;
    public boolean predictTheWinner(int[] nums) {
        dp=new int[nums.length][nums.length];
        for(int[] row:dp) Arrays.fill(row,-1);
        return func(nums,0,nums.length-1)>=0;
    }
    int func(int[] nums , int i, int j){
        if(i==j) return nums[i];

        if(dp[i][j]!=-1) return dp[i][j];

        int left=nums[i]-func(nums,i+1,j);
        int right=nums[j]-func(nums,i,j-1);

        return dp[i][j]= Math.max(left,right);
    }
}