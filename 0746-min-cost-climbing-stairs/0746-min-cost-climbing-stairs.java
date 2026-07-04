class Solution {
    // int[] dp;
    // public int minCostClimbingStairs(int[] cost) {
    //     int n=cost.length;
    //     dp=new int[n];
    //     Arrays.fill(dp,-1);
    //     return Math.min(func(cost,0),func(cost,1));
    // }
    // int func(int[] cost, int index){
    //     if(index>=cost.length) return 0;

    //     if(dp[index]!=-1) return dp[index];

    //     return dp[index]=cost[index]+Math.min(func(cost,index+1),func(cost,index+2));
    // }

    public int minCostClimbingStairs(int[] cost){
        int n=cost.length;
        int[] dp=new int[n+2];
        dp[n]=0;
        dp[n+1]=0;

        for(int i=n-1;i>=0;i--){
            dp[i]=cost[i]+Math.min(dp[i+1],dp[i+2]);
        }
        return Math.min(dp[0],dp[1]);
    }
}