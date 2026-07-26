class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        int c=cuts.length;
        int[] arr=new int[c+2];

        dp=new int[c+2][c+2];
        for(int[] row:dp) Arrays.fill(row,-1);

        for(int i=0;i<c;i++){
            arr[i+1]=cuts[i];
        }
        arr[c+1]=n;
        Arrays.sort(arr);
        return func(1,c,arr);
    }
    int func(int i,int j ,int[] cuts){
        if(i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        int cost=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int currCost=cuts[j+1]-cuts[i-1]+func(i,k-1,cuts)+func(k+1,j,cuts);
            cost=Math.min(cost,currCost);
        }
        return dp[i][j]=cost;
    }
}