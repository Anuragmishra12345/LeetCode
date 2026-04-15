class Solution {
    // int[][] dp;
    // public int maxCoins(int[] nums) {
    //     int n=nums.length;
    //     dp=new int[n+2][n+2];
    //     for(int[] row:dp) Arrays.fill(row,-1);
    //     int[] arr=new int[n+2];
    //     arr[0]=1;
    //     arr[n+1]=1;
    //     for(int i=0;i<n;i++){
    //         arr[i+1]=nums[i];
    //     }
    //     return f(1,n,arr);
    // }
    // int f(int i, int j, int[] nums){
    //     if(i>j) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int max=Integer.MIN_VALUE;
    //     for(int k=i;k<=j;k++){
    //         int coin=nums[i-1]*nums[k]*nums[j+1]+f(i,k-1,nums)+f(k+1,j,nums);
    //         max=Math.max(coin,max);
    //     }
    //     return dp[i][j]=max;
    // }

    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+2][n+2];
        int[] arr=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j) continue;
                int max=Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int coin=arr[i-1]*arr[k]*arr[j+1]+dp[i][k-1]+dp[k+1][j];
                    max=Math.max(coin,max);
                }
                dp[i][j]=max;
            }
        }
        return dp[1][n];
    }
}