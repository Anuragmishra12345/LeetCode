class Solution {
    // int[][] dp;

    // public int findTargetSumWays(int[] nums, int target) {
    //     int sum=0;
    //     for(int num:nums) sum+=num;
    //     if (Math.abs(target) > sum || (sum - target) % 2 != 0) return 0;
    //     sum=(sum-target)/2;

    //     dp=new int[nums.length][sum+1];
    //     for (int[] row : dp) Arrays.fill(row, -1);
    //     return f(nums,sum,nums.length-1);
    // }
    // public int f(int[] arr, int sum, int index){
    //     if(index==0){
    //         if(sum==0 && arr[0]==0) return 2;
    //         if(sum==0 || sum==arr[0]) return 1;
    //         return 0;
    //     }
    //     if(dp[index][sum]!=-1) return dp[index][sum];

    //     int nt=f(arr,sum,index-1);
    //     int t=0;
    //     if(arr[index]<=sum) t=f(arr,sum-arr[index],index-1);

    //     return dp[index][sum]=nt+t;
    // }

    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int num:nums) sum+=num;
        if (Math.abs(target) > sum || (sum - target) % 2 != 0) return 0;
        target=(sum-target)/2;

        int[] prev=new int [target+1];
        if(nums[0]==0) prev[0]=2;
        else prev[0]=1;

        if (nums[0] != 0 && nums[0] <= target) prev[nums[0]] = 1;

        for(int i=1;i<nums.length;i++){
            int[] curr=new int[target+1];
            for(int t=0;t<=target;t++){
                int nt=prev[t];
                int tk=0;
                if(nums[i]<=t) tk=prev[t-nums[i]];

                curr[t]=nt+tk;
            }
            prev=curr;
        }
        return prev[target];
    }
}