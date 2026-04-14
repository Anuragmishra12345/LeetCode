class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        int c=cuts.length;
        int[] arr = new int[c + 2];
        arr[0] = 0;
        arr[c + 1] = n;

        for (int i = 0; i < c; i++) {
            arr[i + 1] = cuts[i];
        }

        Arrays.sort(arr);

        dp = new int[c + 2][c + 2];
        for(int[] row:dp) Arrays.fill(row,-1);
        return f(1,c,arr);
    }
    int f(int i, int j, int[] cuts){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost=cuts[j+1]-cuts[i-1]+f(i,k-1,cuts)+f(k+1,j,cuts);
            min=Math.min(min,cost);
        }
        return dp[i][j]=min;
    }
}