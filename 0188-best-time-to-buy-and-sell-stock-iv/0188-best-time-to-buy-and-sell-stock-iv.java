class Solution {
// Tabulation 2D
    // public int maxProfit(int k, int[] prices) {
    //     int n=prices.length;
    //     int[][] ahead=new int[2][k+1];
    //     int[][] curr=new int[2][k+1];

    //     for(int i=n-1;i>=0;i--){
    //         for(int j=0;j<2;j++){
    //             for(int t=1;t<=k;t++){
    //                 if(j==1){
    //                     curr[j][t]=Math.max(-prices[i]+ahead[0][t],ahead[1][t]);
    //                 }
    //                 else{
    //                     curr[j][t]=Math.max(prices[i]+ahead[1][t-1], ahead[0][t]);
    //                 }
    //             }
    //         }
    //         ahead=curr.clone();
    //     }
    //     return ahead[1][k];
    // }

// Tabulation 1D
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        if(k>=n/2){
            int profit=0;
            for(int i=1;i<n;i++){
                if(prices[i]>prices[i-1]){
                    profit+=prices[i]-prices[i-1];
                }
            }
            return profit;
        }

        int[] buy=new int[k+1];
        int[] sell=new int[k+1];

        Arrays.fill(buy, Integer.MIN_VALUE);

        for(int price:prices){
            for(int t=k;t>0;t--){
                sell[t]=Math.max(price+buy[t],sell[t]);
                buy[t]=Math.max(-price+sell[t-1],buy[t]);
            }
        }
        return sell[k];
    }

}