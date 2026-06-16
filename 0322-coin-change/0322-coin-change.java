class Solution {
    int[][] dp;
    int INF=Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        dp=new int[n][amount+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        int result=bfs(coins,n-1,amount);
        return result==INF?-1:result;
    }
    int bfs(int[] coins, int index, int amount){
        if(amount==0) return 0;

        if(amount< 0 || index<0) return INF;
        
        if(dp[index][amount]!=-1) return dp[index][amount];

        int notTake=bfs(coins,index-1,amount);
        int take=bfs(coins,index,amount-coins[index]);
        if(take!=INF) take++;

        return dp[index][amount]=Math.min(take,notTake);
    }



    // public int coinChange(int[] coins, int amount) {
    //     int n=coins.length;
    //     int[][] dp=new int[n][amount+1];
    //     int INF=(int)1e9;

    //     for(int t=0;t<=amount;t++){
    //         if(t%coins[0]==0) dp[0][t]=t/coins[0];
    //         else dp[0][t]=INF;
    //     }

    //     for(int i=1;i<n;i++){
    //         for(int t=0;t<=amount;t++){
    //             int notTake=0+dp[i-1][t];
    //             int take=INF;
    //             if(coins[i]<=t) take=1+dp[i][t-coins[i]];

    //             dp[i][t]=Math.min(notTake,take);
    //         }
    //     }
    //     return (dp[n-1][amount]>=INF)?-1:dp[n-1][amount];
    // }

    // public int coinChange(int[] coins, int amount) {
    //     int n=coins.length;
    //     int[] prev=new int [amount+1];
    //     int INF=(int)1e9;

    //     for(int t=0;t<=amount;t++){
    //         if(t%coins[0]==0) prev[t]=t/coins[0];
    //         else prev[t]=INF;
    //     }

    //     for(int i=1;i<n;i++){
    //         int[] curr=new int [amount+1];
    //         for(int t=0;t<=amount;t++){
    //             int notTake=0+prev[t];
    //             int take=INF;
    //             if(coins[i]<=t) take=1+curr[t-coins[i]];

    //             curr[t]=Math.min(notTake,take);
    //         }
    //         prev=curr;
    //     }
    //     return (prev[amount]>=INF)?-1:prev[amount];
    // }
}