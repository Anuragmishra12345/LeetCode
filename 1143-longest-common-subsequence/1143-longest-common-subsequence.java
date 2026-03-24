class Solution {
    // int[][] dp;
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int n1=text1.length();
    //     int n2=text2.length();
    //     dp=new int[n1][n2];
    //     for(int[] row:dp) Arrays.fill(row,-1);
    //     return f(text1,n1-1,text2,n2-1);
    // }
    // int f(String s1, int n1 , String s2, int n2){
    //     if(n1<0 || n2<0 ) return 0;
    //     if(dp[n1][n2]!=-1) return dp[n1][n2];

    //     if(s1.charAt(n1)==s2.charAt(n2)) return dp[n1][n2]= 1+f(s1,n1-1, s2, n2-1);

    //     return dp[n1][n2]= Math.max(f(s1,n1-1,s2,n2), f(s1,n1, s2, n2-1));
    // }

    // public int longestCommonSubsequence(String text1, String text2) {
    //     int n1=text1.length();
    //     int n2=text2.length();
    //     int[][] dp=new int[n1+1][n2+1];

    //     for(int i=0;i<=n1;i++) dp[i][0]=0;
    //     for(int j=0;j<=n2;j++) dp[0][j]=0;

    //     for(int i=1;i<=n1;i++){
    //         for(int j=1;j<=n2;j++){
    //             if(text1.charAt(i-1)==text2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];

    //             else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
    //         }
    //     }
    //     return dp[n1][n2];
    // }


    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length();
        int n2=text2.length();

        int[] dp=new int[n2+1];
        for(int j=0;j<=n2;j++) dp[j]=0;

        for(int i=1;i<=n1;i++){
            int[] curr=new int[n2+1];
            for(int j=1;j<=n2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)) curr[j]=1+dp[j-1];

                else curr[j]=Math.max(dp[j],curr[j-1]);
            }
            dp=curr;
        } 
        return dp[n2];       
    }
}