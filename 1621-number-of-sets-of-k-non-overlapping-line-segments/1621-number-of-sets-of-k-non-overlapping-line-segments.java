class Solution {
    int MOD=1000000007;
    Integer[][][] dp;
    public int numberOfSets(int n, int k) {
        dp=new Integer[n+1][k+1][2];
        return func(n,0,k,0);
    }
    int func(int n, int i , int k , int isStarted){
        if(k==0) return 1;
        if(i>=n) return 0;

        if(dp[i][k][isStarted]!=null) return dp[i][k][isStarted];

        long ans=0;

        if(isStarted==0){
            int start=func(n,i+1,k,1);
            int skip=func(n,i+1,k,0);
            ans=start+skip;
        }
        else{
            int extend=func(n,i+1,k,1);
            int end=func(n,i,k-1,0);

            ans=extend+end;
        }

        ans=ans%MOD;

        return dp[i][k][isStarted]=(int)ans;
    }
}