// class Solution {
//     int n;
//     int[][] dp;
//     public int lengthOfLIS(int[] nums) {
//         n=nums.length;
//         dp=new int[n][n+1];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return f(nums,0,-1);
//     }
//     int f(int[] nums, int i, int j){
//         if(i==n) return 0;
//         if(dp[i][j+1]!=-1) return dp[i][j+1];

//         int len=f(nums,i+1,j);
//         if(j==-1 || nums[i]>nums[j]) len=Math.max(len,1+f(nums,i+1,i));

//         return dp[i][j+1]=len;
//     }
// }

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);

//         int maxLen = 1;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (nums[i] > nums[j]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }
//             maxLen = Math.max(maxLen, dp[i]);
//         }

//         return maxLen;
//     }
// }

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n=nums.length;
//         int[][] dp=new int[n+1][n+1];
//         for(int i=n-1;i>=0;i--){
//             for(int j=i-1;j>=-1;j--){
//                 int len=dp[i+1][j+1];
//                 if(j==-1 || nums[i]>nums[j]) len=Math.max(len,1+dp[i+1][i+1]);
//                 dp[i][j+1]=len;
//             }
//         }
//         return dp[0][0];
//     }
// }

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length; 
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) dp[i]=Math.max(dp[i],1+dp[j]);
            }
        }
        return dp[n-1];
    }
}