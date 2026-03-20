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
        boolean[] prev=new boolean[target+1];
    
        prev[0]=true;
        if(arr[0]<= target) prev[arr[0]]=true;
        for(int i=1;i<n;i++){
            boolean[] curr=new boolean[target+1];
            curr[0]=true;
            for(int k=1;k<=target;k++){
                boolean notTake=prev[k];
                boolean take=false;
                if(arr[i]<=k) take=prev[k-arr[i]];
                curr[k]=take|| notTake;
            }
            prev=curr;
        }
        return prev[target];
    }
}