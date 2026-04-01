class Solution {
    int[][] dp;
    int n;
    public int maxProfit(int[] prices) {
        n=prices.length;
        dp=new int[n+1][2];
        for(int[] row: dp) Arrays.fill(row,-1);
        return f(prices,0,1);
    }
    int f(int[] prices, int index, int status){
        if(index>=n) return 0;

        if(dp[index][status]!=-1) return dp[index][status];

        int profit=0;
        if(status==1){
            profit=Math.max(-prices[index]+f(prices,index+1,0),f(prices,index+1,1));
        }
        else profit=Math.max(prices[index]+f(prices,index+2,1),f(prices,index+1,0));

        return dp[index][status]=profit;
    }
}