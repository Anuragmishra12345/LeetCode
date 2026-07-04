class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        return Math.min(func(cost,0),func(cost,1));
    }
    int func(int[] cost, int index){
        if(index>=cost.length) return 0;

        if(dp[index]!=-1) return dp[index];

        return dp[index]=cost[index]+Math.min(func(cost,index+1),func(cost,index+2));
    }
}