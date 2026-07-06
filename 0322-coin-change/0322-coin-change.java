class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;

        dp=new int[coins.length][amount+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        int result=bfs(coins,amount,0);
        return result==Integer.MAX_VALUE?-1:result;
    }
    int bfs(int[] coins, int amt, int index){
        if(index==coins.length && amt!=0) return Integer.MAX_VALUE;
        if(amt==0) return 0;

        if(dp[index][amt]!=-1) return dp[index][amt];

        int take=Integer.MAX_VALUE;
        if(amt>=coins[index]){
            int res=bfs(coins,amt-coins[index],index);
            if(res!=Integer.MAX_VALUE) take=1+res;
        }

        
        int notTake=bfs(coins,amt,index+1);

        return dp[index][amt]=Math.min(take,notTake);
    }
}