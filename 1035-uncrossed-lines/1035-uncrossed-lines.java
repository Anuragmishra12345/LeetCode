class Solution {
    Integer[][] dp;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        dp=new Integer[nums1.length][nums2.length];
        return solve(nums1,nums2,0,0);
    }
    int solve(int[] nums1, int[] nums2, int i, int j){
        if(i==nums1.length || j==nums2.length) return 0;

        if(dp[i][j]!=null) return dp[i][j];

        int ans=0;

        if(nums1[i]==nums2[j]) ans=Math.max(ans,1+solve(nums1,nums2,i+1,j+1));
        
        ans=Math.max(ans,Math.max(solve(nums1,nums2,i,j+1),solve(nums1,nums2,i+1,j)));
        return dp[i][j]=ans;
    }
}