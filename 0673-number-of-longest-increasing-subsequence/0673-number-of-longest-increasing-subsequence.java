class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int max=1;
        int[] dp=new int[n];
        int[] count=new int[n];
        Arrays.fill(count,1);
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    count[i]=count[j];
                } 
                else if(nums[i]>nums[j] && dp[i]==dp[j]+1){
                    count[i]+=count[j];
                }
            }
            max=Math.max(max,dp[i]);  
        }
        int res=0;
        for(int i=0;i<n;i++){
            if(dp[i]==max) res+=count[i];
        }
        return res;
    }
}