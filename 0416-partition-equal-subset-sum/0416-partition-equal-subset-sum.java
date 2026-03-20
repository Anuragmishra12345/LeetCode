class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++) sum+=nums[i];
        if(sum%2!=0) return false;
        int target=sum/2;
        // boolean[] dp=new boolean[target+1];
        // dp[0]=true;

        // for(int num: nums){
        //     for(int k=target; k>=num; k--){
        //         dp[k]=dp[k] || dp[k-num];
        //     }
        // }
        // return dp[target];
        return f(nums,target);
        
    }
    boolean f(int[] arr, int target){
        int n=arr.length;
        boolean[][] dp=new boolean[n][target+1];
        for(int i=0;i<n;i++) dp[i][0]=true;
        if (arr[0] <= target) dp[0][arr[0]] = true;
        for(int i=1;i<n;i++){
            for(int k=1;k<=target;k++){
                boolean notTake=dp[i-1][k];
                boolean take=false;
                if(arr[i]<=k) take=dp[i-1][k-arr[i]];
                dp[i][k]=take|| notTake;
            }
        }
        return dp[n-1][target];
    }
}