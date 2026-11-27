class Solution {
    int[] copy;
    int[][] dp;
    int minPrice=Integer.MAX_VALUE;
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;
        copy=new int[n];
        dp=new int[n][budget+1];
        for(int[] d:dp) Arrays.fill(d,-1);

        for(int i=0;i<n;i++){
            copy[i]=1;
            minPrice=Math.min(minPrice,items[i][1]);
            for(int j=0;j<n;j++){
                if(i==j) continue;

                if(items[j][0]%items[i][0]==0) {
                    copy[i]++;
                }
            }
        }

        return dfs(items,0,budget);
    }

    int dfs(int[][] items, int i, int budget){
        if(i>=items.length || budget<=0) return budget/minPrice;

        if(dp[i][budget]!=-1) return dp[i][budget];

        int take=0;
        int notTake=dfs(items,i+1,budget);

        if(items[i][1]<=budget){
            take=copy[i];
            take+=dfs(items,i+1,budget-items[i][1]);
        }

        return dp[i][budget]=Math.max(take,notTake);
    }

}