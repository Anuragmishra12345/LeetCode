class Solution {
    int[] dp;
    public int integerBreak(int n) {
        dp=new int[n+1];
        return solve(n);
    }
    int solve(int n){
        if(n==1) return 1;
        if(dp[n]!=0) return dp[n];
        int ans=0;
        for(int i=1;i<=n;i++){
            ans=Math.max(ans,Math.max((n-i)*i,i*solve(n-i)));
        }
        return dp[n]=ans;
    }
}