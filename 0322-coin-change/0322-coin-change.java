class Solution {
    int[][] dp;
    int INF=(int)1e9;
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        dp=new int[n][amount+1];
        for(int[] row:dp) Arrays.fill(row,-1);

        int ans = f(n - 1, coins, amount);
        return ans >= INF ? -1 : ans;
    }
    int f(int index, int[] coins, int amt){
        if(index==0){
            if(amt%coins[0]==0) return amt;
            else return INF;
        }
        if(dp[index][amt]!=-1) return dp[index][amt];

        int notTake=0+f(index-1,coins,amt);
        int take=INF;
        if(coins[index]<=amt) take=1+f(index,coins,amt-coins[index]);

        return dp[index][amt]=Math.min(notTake,take);
    }
    // public int coinChange(int[] coins, int amount) {
    //     int n=coins.length;
    //     int[][] dp=new int[n][amount+1];
    //     int INF=(int)1e9;


    // }
}