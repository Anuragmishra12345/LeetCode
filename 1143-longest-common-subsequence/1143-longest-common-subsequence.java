class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length();
        int n2=text2.length();
        dp=new int[n1][n2];
        for(int[] row:dp) Arrays.fill(row,-1);
        return f(text1,n1-1,text2,n2-1);
    }
    int f(String s1, int n1 , String s2, int n2){
        if(n1<0 || n2<0 ) return 0;
        if(dp[n1][n2]!=-1) return dp[n1][n2];

        if(s1.charAt(n1)==s2.charAt(n2)) return dp[n1][n2]= 1+f(s1,n1-1, s2, n2-1);

        return dp[n1][n2]= Math.max(f(s1,n1-1,s2,n2), f(s1,n1, s2, n2-1));
    }
}