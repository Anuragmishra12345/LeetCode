class Solution {
    // Integer[] dp;
    // public String stoneGameIII(int[] stoneValue) {
    //     dp=new Integer[stoneValue.length];
    //     int result=func(stoneValue,0);
    //     if(result>0) return "Alice";
    //     else if(result<0) return "Bob";
    //     else return "Tie";
    // }
    // int func(int[] nums, int i){
    //     if(i==nums.length) return 0;

    //     if(dp[i]!=null) return dp[i];

    //     int result=nums[i]-func(nums,i+1);
    //     if(i+1<nums.length) result=Math.max(result,nums[i]+nums[i+1]-func(nums,i+2));
    //     if(i+2<nums.length) result=Math.max(result,nums[i]+nums[i+1]+nums[i+2]-func(nums,i+3));

    //     return dp[i]=result;
    // }

    public String stoneGameIII(int[] stoneValue) {
        int[] dp=new int[stoneValue.length+1];

        for(int i=stoneValue.length-1;i>=0;i--){
            int result=stoneValue[i]-dp[i+1];
            if(i+1<stoneValue.length) result=Math.max(result,stoneValue[i]+stoneValue[i+1]-dp[i+2]);
            if(i+2<stoneValue.length) result=Math.max(result,stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-dp[i+3]);

            dp[i]=result;
        }
        if(dp[0]>0) return "Alice";
        else if(dp[0]<0) return "Bob";
        else return "Tie";
    }
}