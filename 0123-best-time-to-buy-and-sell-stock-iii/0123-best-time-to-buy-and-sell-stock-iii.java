class Solution {
// Recursive 

    // int[][][] dp;
    // public int maxProfit(int[] prices) {
    //     int n=prices.length;
    //     dp=new int[n][2][3];
    //     for(int[][] table:dp) {
    //         for(int[] row: table ) Arrays.fill(row,-1);
    //     }
    //     return f(prices,0,1,2);
    // }
    // int f(int[] prices, int index, int status, int t){
    //     if(t==0 || index==prices.length){
    //         return 0;
    //     }
    //     if(dp[index][status][t]!=-1) return dp[index][status][t];
    //     long profit=0;
    //     if(status==1){
    //         profit=Math.max(-prices[index]+f(prices,index+1,0,t),f(prices,index+1,1,t));
    //     }
    //     else {
    //         profit=Math.max(prices[index]+f(prices,index+1,1,t-1),f(prices,index+1,0,t));
    //     }

    //     return dp[index][status][t]=(int)profit;
    // }

//  Tabulation 3D

    // public int maxProfit(int[] prices) {
    //     int n=prices.length;
    //     int[][][] dp=new int[n+1][2][3];

    //     for(int i=n-1;i>=0;i--){
    //         for(int j=0;j<2;j++){
    //             for(int t=1;t<=2;t++){
                    // if(j==1){
                    //     dp[i][j][t]=Math.max(-prices[i]+dp[i+1][0][t], dp[i+1][1][t]);
                    // }
                    // else {
                    //     dp[i][j][t]=Math.max(prices[i]+dp[i+1][1][t-1], dp[i+1][0][t]);
                    // }
    //             }
    //         }
    //     }
    //     return dp[0][1][2];
    // }

// Tabulation 2D

    public int maxProfit(int[] prices) {
        int n=prices.length;

        int[][] ahead=new int[2][3];
        int[][] curr=new int[2][3];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                for(int t=1;t<=2;t++){
                    if(j==1){
                        curr[j][t]=Math.max(-prices[i]+ahead[0][t], ahead[1][t]);
                    }
                    else {
                        curr[j][t]=Math.max(prices[i]+ahead[1][t-1], ahead[0][t]);
                    }
                }
            }
            ahead=curr.clone();
        }
        return ahead[1][2];
    }    
}