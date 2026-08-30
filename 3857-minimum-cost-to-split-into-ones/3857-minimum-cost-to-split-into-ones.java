class Solution {
    int[] dp;
    public int minCost(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return func(n);
    }
    private int func(int n){
        if(n==1) return 0; 
        if(dp[n]!=-1) return dp[n];
        int cost=Integer.MAX_VALUE;
        for(int i=1;i<=n/2;i++){
            cost=Math.min(cost,i*(n-i)+func(i)+func(n-i));
        }
        return dp[n]=cost;
    }
}