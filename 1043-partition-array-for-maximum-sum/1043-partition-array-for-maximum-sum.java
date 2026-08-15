class Solution {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return func(arr,0,k);
    }
    int func(int[] arr, int i, int k){
        if(i==arr.length) return 0;

        if(dp[i]!=-1) return dp[i];

        int max=0;
        int best=0;
        for(int j=i;j<arr.length && j<i+k;j++){
            max=Math.max(max,arr[j]);
            int len=j-i+1;
            int curr=max*len+func(arr,j+1,k);
            best=Math.max(best,curr);
        }
        return dp[i]=best;
    }
}