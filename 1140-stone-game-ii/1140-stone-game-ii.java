class Solution {
    // Integer[][] dp;
    // int[] suffix;
    // int n;
    // public int stoneGameII(int[] piles) {
    //     n=piles.length;
    //     dp=new Integer[n][n+1];
    //     suffix=new int[n+1];
    //     for(int i=n-1;i>=0;i--){
    //         suffix[i]=suffix[i+1]+piles[i];
    //     }
    //     return func(0,1);
    // }
    
    // int func(int i ,int m){
    //     if(i+2*m>=n) return suffix[i];

    //     if(dp[i][m]!=null) return dp[i][m];

    //     int best=0;

    //     for(int x=1;x<=2*m;x++){
    //         int opponent=func(i+x,x);

    //         int current=suffix[i]-opponent;

    //         best=Math.max(best,current);
    //     }
    //     return dp[i][m]=best;
    // }

    public int stoneGameII(int[] piles){
        int n=piles.length;
        Integer[][] dp=new Integer[n+1][n+1];
        int[] suffix=new int[n+1];
        for(int i=n-1;i>=0;i--){
            suffix[i]=suffix[i+1]+piles[i];
        }

        for(int i=n-1;i>=0;i--){
            for(int m=n;m>=1;m--){

                if(i+2*m>=n) {
                    dp[i][m]=suffix[i];
                    continue;
                }

                int best=0;
                for(int x=1;x<=2*m;x++){
                    int newM = Math.max(m,x);
                    int opponent=dp[i+x][newM];
                    int current=suffix[i]-opponent;
                    best=Math.max(best,current);
                }
                dp[i][m]=best;
            }
        }
        return dp[0][1];
    }
}