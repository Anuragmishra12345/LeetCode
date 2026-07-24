class Solution {
    // int[][] dp;
    // public int longestCommonSubsequence(String text1, String text2) {
    //     dp=new int[text1.length()][text2.length()];
    //     for(int[] row:dp) Arrays.fill(row,-1);
    //     return func(text1,text2,0,0);
    // }

    // int func(String s1, String s2, int i , int j){
    //     if(i>=s1.length() || j>=s2.length()) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];

    //     int take=0;
    //     if(s1.charAt(i)==s2.charAt(j)) take=1+func(s1,s2,i+1,j+1);

    //     int notTake=Math.max(func(s1,s2,i+1,j),func(s1,s2,i,j+1));

    //     return dp[i][j]=Math.max(take,notTake);
    // }

    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[] dp=new int[n+1];

        for(int i=m-1;i>=0;i--){
            int[] curr=new int[n+1];
            for(int j=n-1;j>=0;j--){
                int take=0;
                if(text1.charAt(i)==text2.charAt(j)) take=1+dp[j+1];
                int notTake=Math.max(dp[j],curr[j+1]);

                curr[j]=Math.max(take,notTake);
            }
            dp=curr;
        }
        return dp[0];
    }
}