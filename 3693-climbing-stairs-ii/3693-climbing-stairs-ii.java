class Solution {
    int[] dp;
    public int climbStairs(int n, int[] costs) {
        dp=new int[n];
        Arrays.fill(dp,-1);
        return solver(costs,0);
    }

    int solver(int[] costs, int i){
        if(i== costs.length) return 0;

        if(dp[i]!=-1) return dp[i];

        int cost=Integer.MAX_VALUE;
        if(i+1<=costs.length) cost=costs[i]+1+solver(costs,i+1);
        if(i+2<=costs.length) cost=Math.min(cost,costs[i+1]+4+solver(costs,i+2));
        if(i+3<=costs.length) cost=Math.min(cost,costs[i+2]+9+solver(costs,i+3));

        return dp[i]=cost;
    }
}