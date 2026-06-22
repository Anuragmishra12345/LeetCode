class Solution {
    int[][] states = {
            {0,1},
            {0,2},
            {1,0},
            {1,2},
            {2,0},
            {2,1}
    };
    long[][] dp;
    public long minCost(int n, int[][] cost) {
        dp=new long[n/2][7];
        for(long[] row : dp){
            Arrays.fill(row, -1);
        }

        return dfs(0,cost,n,6);
    }
    long dfs(int index, int[][] cost, int n, int prevState){
        if(index==n/2) return 0;

        if(dp[index][prevState]!=-1) return dp[index][prevState];
        long ans=Long.MAX_VALUE;
        for(int currState=0;currState<6;currState++){

            int leftColor=states[currState][0];
            int rightColor=states[currState][1];

            if(prevState!=6){
                int prevLeft=states[prevState][0];
                int prevRight=states[prevState][1];

                if(prevLeft==leftColor || prevRight==rightColor) continue;
            }
            int minCost=cost[index][leftColor]+cost[n-index-1][rightColor];

            ans=Math.min(ans,minCost+dfs(index+1,cost,n,currState));
        }
        return dp[index][prevState]=ans;
    }
}