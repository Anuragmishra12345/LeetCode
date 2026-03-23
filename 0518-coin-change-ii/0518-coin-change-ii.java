class Solution {
    // int[][] dp;
    // public int change(int amount, int[] coins) {
    //     int n=coins.length;
    //     dp=new int[n][amount+1];
    //     for(int[] row:dp) Arrays.fill(row,-1);

    //     return f(coins,amount,n-1);
    // }
    // int f(int[] coins, int amt,int index){
    //     if(index==0){
    //         if(amt%coins[0]==0) return 1;
    //         else return 0;
    //     }
    //     if(dp[index][amt]!=-1) return dp[index][amt];

    //     int nt=f(coins,amt,index-1);
    //     int t=0;
    //     if(coins[index]<=amt) t=f(coins,amt-coins[index],index);

    //     return dp[index][amt]=nt+t;
    // }

    // public int change(int amount, int[] coins) {
    //     int n=coins.length;
    //     int[] prev=new int[amount+1];
    //     for(int i=0;i<=amount;i++){
    //         if(i%coins[0]==0) prev[i]=1;
    //         else prev[i]=0;
    //     }

    //     for(int i=1;i<n;i++){
    //         int[] curr=new int[amount+1];
    //         for(int target=0;target<=amount;target++){

    //             int nt=prev[target];
    //             int t=0;
    //             if(coins[i]<=target) t=curr[target-coins[i]];

    //             curr[target]=nt+t;
    //         }
    //         prev=curr;
    //     }
    //     return prev[amount];
    // }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int t = coin; t <= amount; t++) {
                dp[t] += dp[t - coin];
            }
        }

        return dp[amount];
    }
}