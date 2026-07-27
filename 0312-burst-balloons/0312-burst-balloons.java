class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n=nums.length;
        dp=new int[n+2][n+2];
        for(int[] row:dp) Arrays.fill(row,-1);
        int[] arr=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        return func(arr,1,n);
    }
    int func(int[] nums, int i, int j){
        if(i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int coins=0;
        for(int k=i;k<=j;k++){
            int c=nums[i-1]*nums[k]*nums[j+1] +func(nums,i,k-1)+func(nums,k+1,j);
            coins=Math.max(coins,c);
        }
        return dp[i][j]=coins;
    }
}