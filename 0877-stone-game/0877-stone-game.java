class Solution {
    // Integer[][] dp;
    // public boolean stoneGame(int[] piles) {
    //     dp=new Integer[piles.length][piles.length];

    //     return func(piles,0,piles.length-1)>=0;
    // }
    // int func(int[] piles, int i, int j){
    //     if(i==j) return piles[i];

    //     if(dp[i][j]!=null) return dp[i][j];

    //     int left=piles[i]-func(piles,i+1,j);
    //     int right=piles[j]-func(piles,i,j-1);

    //     return dp[i][j]=Math.max(left,right);
    // }

    // public boolean stoneGame(int[] piles){
    //     int[][] dp=new int[piles.length+1][piles.length+1];
    //     for(int i=0;i<piles.length;i++){
    //         dp[i][i]=piles[i];
    //     }

    //     for(int i=piles.length-1;i>=0;i--){
    //         for(int j=i+1;j<piles.length;j++){
                
    //             int left=piles[i]-dp[i+1][j];
    //             int right=piles[j]-dp[i][j-1];

    //             dp[i][j]=Math.max(left,right);
    //         }
    //     }

    //     return dp[0][piles.length-1]>0;
    
    // }

    public boolean stoneGame(int[] piles){ return true;}
}