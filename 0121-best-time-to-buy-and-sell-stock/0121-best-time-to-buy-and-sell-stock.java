class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=prices[0];
        int maxProfit=0;

        for(int n:prices){
            if(n<minPrice){
                minPrice=n;
            }
            else maxProfit=Math.max(maxProfit,n-minPrice);
        }
        return maxProfit;
    }
}