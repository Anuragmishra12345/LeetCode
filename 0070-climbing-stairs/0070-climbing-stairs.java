class Solution {
    Integer[] dp;
    public int climbStairs(int n) {
        dp=new Integer[n+1];
        // int[] dp=new int[n+1];
        // if(1<=n)dp[1]=1;
        // if(2<=n)dp[2]=2;
        // if(3<=n)dp[3]=3;
        // for(int i=4;i<=n;i++){
        //     dp[i]=dp[i-1]+dp[i-2];
        // }
        // return dp[n];

        return dfs(n);
    }
    int dfs(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 3;

        if(dp[n]!=null) return dp[n];

        int oneStep=dfs(n-1);
        int twoStep=dfs(n-2);

        return dp[n]=oneStep+twoStep;
    }
}