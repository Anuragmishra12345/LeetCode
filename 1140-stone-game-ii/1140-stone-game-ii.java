class Solution {
    Integer[][] dp;
    int[] suffix;
    int n;
    public int stoneGameII(int[] piles) {
        n=piles.length;
        dp=new Integer[n][n+1];
        suffix=new int[n+1];
        for(int i=n-1;i>=0;i--){
            suffix[i]=suffix[i+1]+piles[i];
        }
        return func(0,1);
    }
    
    int func(int i, int m){
        if(i+2*m>=n) return suffix[i];

        if(dp[i][m]!=null) return dp[i][m];

        int best=0;

        for(int x=1;x<=2*m;x++){
            int newM=Math.max(m,x);

            int opponent=func(i+x,newM);

            int current=suffix[i]-opponent;

            best=Math.max(best,current);
        } 

        return dp[i][m]=best;
    }
}