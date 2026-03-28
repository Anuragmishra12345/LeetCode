class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        // for (int price : prices) {
        //     if (price < minPrice) {
        //         minPrice = price;          
        //     } else {
        //         maxProfit = Math.max(maxProfit, price - minPrice);
        //     }
        // }

        for(int i=1;i<prices.length;i++){
            int profit=prices[i]-minPrice;
            maxProfit=Math.max(maxProfit,profit);
            minPrice=Math.min(minPrice,prices[i]);
        }
        return maxProfit;
    }
}