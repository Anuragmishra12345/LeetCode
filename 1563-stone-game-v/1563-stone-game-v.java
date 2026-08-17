class Solution {
    int[][] dp;
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;

        int[] prefixSum=new int[n+1];
        for(int i=0;i<n;i++){
            prefixSum[i+1]=prefixSum[i]+stoneValue[i];
        }

        dp=new int[n+1][n+1];
        for(int [] d: dp) Arrays.fill(d,-1);

        return partion(prefixSum,0,n-1);
    }
    int partion(int[] prefix, int i, int j){
        if(j-i+1==1) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int totalSum=prefix[j+1]-prefix[i];
        int best=0;
        for(int start=i;start<=j;start++){
            int leftSum=prefix[start+1]-prefix[i];
            int rightSum=totalSum-leftSum;

            int currScore=0;
            if(leftSum<rightSum){
                currScore=leftSum+partion(prefix,i,start);
            }
            else if(rightSum<leftSum){
                currScore=rightSum+partion(prefix,start+1,j);
            }
            else {
                currScore=leftSum+Math.max(partion(prefix,i,start),partion(prefix,start+1,j));
            }
            best=Math.max(best,currScore);
        }
        return dp[i][j]=best;
    }
}