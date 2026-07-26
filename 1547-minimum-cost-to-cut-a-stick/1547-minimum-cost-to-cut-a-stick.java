class Solution {
    // int[][] dp;
    // public int minCost(int n, int[] cuts) {
    //     int c=cuts.length;
    //     int[] arr=new int[c+2];

    //     dp=new int[c+2][c+2];
    //     for(int[] row:dp) Arrays.fill(row,-1);

    //     for(int i=0;i<c;i++){
    //         arr[i+1]=cuts[i];
    //     }
    //     arr[c+1]=n;
    //     Arrays.sort(arr);
    //     return func(1,c,arr);
    // }
    // int func(int i,int j ,int[] cuts){
    //     if(i>j) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int cost=Integer.MAX_VALUE;
    //     for(int k=i;k<=j;k++){
    //         int currCost=cuts[j+1]-cuts[i-1]+func(i,k-1,cuts)+func(k+1,j,cuts);
    //         cost=Math.min(cost,currCost);
    //     }
    //     return dp[i][j]=cost;
    // }

    public int minCost(int n, int[] cuts) {
        int c=cuts.length;
        int[] arr=new int[c+2];

        int[][] dp=new int[c+2][c+2];

        for(int i=0;i<c;i++){
            arr[i+1]=cuts[i];
        }
        arr[c+1]=n;
        Arrays.sort(arr);

        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
                if(i>j) continue;
                int cost=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int currCost=arr[j+1]-arr[i-1]+ dp[i][k-1]+dp[k+1][j];
                    cost=Math.min(cost,currCost);
                }
                dp[i][j]=cost;
            }
        }
        return dp[1][c];
    }
}