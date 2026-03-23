class Solution {
    // int[][] dp;
    // int INF=(int)1e9;
    // public int coinChange(int[] coins, int amount) {
    //     int n=coins.length;
    //     dp=new int[n][amount+1];
    //     for(int[] row:dp) Arrays.fill(row,-1);

    //     int ans = f(n - 1, coins, amount);
    //     return ans >= INF ? -1 : ans;
    // }
    // int f(int index, int[] coins, int amt){
    //     if(index==0){
    //         if(amt%coins[0]==0) return amt/coins[0];
    //         else return INF;
    //     }
    //     if(dp[index][amt]!=-1) return dp[index][amt];

    //     int notTake=0+f(index-1,coins,amt);
    //     int take=INF;
    //     if(coins[index]<=amt) take=1+f(index,coins,amt-coins[index]);

    //     return dp[index][amt]=Math.min(notTake,take);
    // }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        int INF=(int)1e9;

        for(int t=0;t<=amount;t++){
            if(t%coins[0]==0) dp[0][t]=t/coins[0];
            else dp[0][t]=INF;
        }

        for(int i=1;i<n;i++){
            for(int t=0;t<=amount;t++){
                int notTake=0+dp[i-1][t];
                int take=INF;
                if(coins[i]<=t) take=1+dp[i][t-coins[i]];

                dp[i][t]=Math.min(notTake,take);
            }
        }
        return (dp[n-1][amount]>=INF)?-1:dp[n-1][amount];
    }
}