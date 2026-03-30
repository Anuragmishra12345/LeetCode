class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new int[n][2][3];
        for(int[][] table:dp) {
            for(int[] row: table ) Arrays.fill(row,-1);
        }
        return f(prices,0,1,2);
    }
    int f(int[] prices, int index, int status, int t){
        if(t==0 || index==prices.length){
            return 0;
        }
        if(dp[index][status][t]!=-1) return dp[index][status][t];
        long profit=0;
        if(status==1){
            profit=Math.max(-prices[index]+f(prices,index+1,0,t),f(prices,index+1,1,t));
        }
        else {
            profit=Math.max(prices[index]+f(prices,index+1,1,t-1),f(prices,index+1,0,t));
        }

        return dp[index][status][t]=(int)profit;
    }
}