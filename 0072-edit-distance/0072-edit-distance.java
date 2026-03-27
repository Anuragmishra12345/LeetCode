class Solution {
    int[][] dp;
    public int minDistance(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();

        dp=new int[n1+1][n2+1];
        for(int [] row:dp) Arrays.fill(row,-1);
        return f(s1,s2,n1-1,n2-1);
    }
    int f(String s1, String s2, int n1 , int n2){
        if(n1<0) return n2+1;
        if(n2<0) return n1+1;

        if(dp[n1][n2]!=-1) return dp[n1][n2];
        if(s1.charAt(n1)==s2.charAt(n2)) return dp[n1][n2]= f(s1,s2,n1-1,n2-1);

        return dp[n1][n2]=Math.min(1+f(s1,s2,n1-1,n2),Math.min(1+f(s1,s2,n1,n2-1),1+f(s1,s2,n1-1,n2-1)));
    }
}