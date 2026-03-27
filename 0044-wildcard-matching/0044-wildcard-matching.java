class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        dp=new Boolean[n+1][m+1];
        return f(s,p,n-1,m-1);
    }
    boolean f(String s, String p, int i, int j){
        if(i<0 && j<0 ) return true;
        if(j<0 && i>=0) return false;
        if(j>=0 && i<0) {
            for(int k=0;k<=j;k++){ if(p.charAt(k)!='*') return false;}
            return true;
        }
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') return dp[i][j]=f(s,p,i-1,j-1);

        if(p.charAt(j)=='*') return dp[i][j]=f(s,p,i-1,j) || f(s,p,i,j-1);

        return dp[i][j]=false;
    }
}