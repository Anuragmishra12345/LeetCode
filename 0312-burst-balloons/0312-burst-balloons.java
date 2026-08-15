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
    //     return func(arr,1,n);
    // }
    // int func(int[] nums, int i, int j){
    //     if(i>j) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];

    //     int coins=0;
    //     for(int k=i;k<=j;k++){
    //         int c=nums[i-1]*nums[k]*nums[j+1] +func(nums,i,k-1)+func(nums,k+1,j);
    //         coins=Math.max(coins,c);
    //     }
    //     return dp[i][j]=coins;
    // }


    // public int maxCoins(int[] nums) {
    //     int n=nums.length;
    //     int[][] dp=new int[n+2][n+2];
    //     int[] arr=new int[n+2];
    //     arr[0]=1;
    //     arr[n+1]=1;
    //     for(int i=0;i<n;i++){
    //         arr[i+1]=nums[i];
    //     }

    //     for(int i=n;i>=1;i--){
    //         for(int j=1;j<=n;j++){
    //             int cost=0;
    //             for(int k=i;k<=j;k++){
    //                 int c=arr[i-1]*arr[k]*arr[j+1]+dp[i][k-1]+dp[k+1][j];
    //                 cost=Math.max(cost,c);
    //             }
    //             dp[i][j]=cost;
    //         }
    //     }
    //     return dp[1][n];
    // }


    Integer[][] dp;
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        dp=new Integer[n+2][n+2];
        arr[0]=1;
        arr[n+1]=1;

        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }

        return dfs(1,n,arr);
    }

    int dfs(int i, int j, int[] arr){
        if(i>j) return 0;

        if(dp[i][j]!=null) return dp[i][j];

        int maxCoin=0;
        for(int k=i;k<=j;k++){
            int coin=arr[i-1]*arr[k]*arr[j+1]+dfs(i,k-1,arr)+dfs(k+1,j,arr);
            maxCoin=Math.max(maxCoin,coin);
        }
        return dp[i][j]=maxCoin;
    }























}