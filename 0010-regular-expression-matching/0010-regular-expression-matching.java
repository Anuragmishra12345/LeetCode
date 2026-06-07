class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp=new Boolean[s.length()+1][p.length()+1];
        return solve(s,p,0,0);
    }
    boolean solve(String s, String p, int i, int j){
        if(dp[i][j]!=null) return dp[i][j];
        if(j==p.length()){
            return dp[i][j]=(i==s.length());
        }

        boolean firstMatch=i<s.length() && (p.charAt(j)=='.' || s.charAt(i)==p.charAt(j)) ;
        boolean ans=false;
        if(j+1<p.length() && p.charAt(j+1)=='*') {
            boolean skip=solve(s,p,i,j+2);
            boolean use=firstMatch && solve(s,p,i+1,j);

            ans=skip || use;
        }
        else{
            ans=firstMatch && solve(s,p,i+1,j+1);
        }


        return dp[i][j]=ans;
    }
}