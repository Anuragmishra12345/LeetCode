class Solution {
    int[][] dp;
    int n;
    public int maxProfit(int[] prices, int fee) {
        n=prices.length;
        dp=new int[n][2];
        for(int [] row:dp) Arrays.fill(row,-1);
        return f(prices,0,1,fee);
    }
    int f(int[] prices, int index, int status,int fee){
        if(index==n) return 0;
        long profit=0;

        if(dp[index][status]!=-1) return dp[index][status];

        if(status==1){
            profit=Math.max(-fee-prices[index]+f(prices,index+1,0,fee),
                    0+f(prices,index+1,1,fee));
        }
        else {
            profit=Math.max(prices[index]+f(prices,index+1,1,fee),
                            0+f(prices,index+1,0,fee));
        }
        return dp[index][status]=(int)profit;
    } 
}