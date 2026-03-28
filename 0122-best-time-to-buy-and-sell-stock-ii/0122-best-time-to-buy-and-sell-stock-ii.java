class Solution {
// DP recursive
    // int[][] dp;
    // int n;
    // public int maxProfit(int[] prices) {
    //     n=prices.length;
    //     dp=new int[n][2];
    //     for(int [] row:dp) Arrays.fill(row,-1);
    //     return f(prices,0,1);
    // }
    // int f(int[] prices, int index, int status){
    //     if(index==n) return 0;
    //     long profit=0;

    //     if(dp[index][status]!=-1) return dp[index][status];

    //     if(status==1){
    //         profit=Math.max(-prices[index]+f(prices,index+1,0),
    //                 0+f(prices,index+1,1));
    //     }
    //     else {
    //         profit=Math.max(prices[index]+f(prices,index+1,1),
    //                         0+f(prices,index+1,0));
    //     }
    //     return dp[index][status]=(int)profit;
    // } 

// DP Tabulation 1D
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] dp=new int[2];

        for(int i=n-1;i>=0;i--){
            int[] curr=new int[2];
            int profit=0;
            for(int j=0;j<=1;j++){
                if(j==1){
                    profit=Math.max(-prices[i]+dp[0],dp[1]);
                }
                else {
                    profit=Math.max(prices[i]+dp[1],dp[0]);
                }
                curr[j]=profit;
            }
            dp=curr;
        }
        return dp[1];
    }

// Greedy
    // public int maxProfit(int[] prices){
    //     int profit=0;
    //     for(int i=1;i<prices.length;i++){
    //         if(prices[i]>prices[i-1]) profit+=prices[i]-prices[i-1];
    //     }
    //     return profit;
    // }
}