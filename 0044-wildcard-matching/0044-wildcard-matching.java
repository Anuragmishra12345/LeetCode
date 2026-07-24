class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp=new Boolean[s.length()][p.length()];
        return func(s,p,0,0);
    }
    boolean func(String s, String p, int i, int j){
        if(i==s.length() && j==p.length()) return true;
        if(j>=p.length() && i<s.length()) return false;
        if(j<p.length() && i>=s.length()){
            for(int index=j;index<p.length();index++) if(p.charAt(index)!='*') return false;
            return true;
        }


        if(dp[i][j] !=null) return dp[i][j];

        boolean same=false;
        boolean star=false;
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') same=func(s,p,i+1,j+1);
        else if(p.charAt(j)=='*') star=func(s,p,i,j+1) || func(s,p,i+1,j);
        else return dp[i][j]=false;

        return dp[i][j]=same|| star;
    }

    // public boolean isMatch(String s, String p) {
    //     int m=s.length();
    //     int n=p.length();

    //     boolean[] dp=new boolean[p.length()+1];
    //     dp[n]=true;
        
    //     for(int i=m-1;i>=0;i--){
    //         boolean[] curr=new boolean[p.length()+1];
    //         for(int j=n-1;j>=0;j--){
    //             boolean same=false;
    //             boolean star=false;

    //             if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') same=dp[j+1];
    //             else if(p.charAt(j)=='*') star=dp[j+1] || dp[j];

    //             curr[j]=same||star;
    //         }
    //         dp=curr;
    //     }
    //     return dp[0];
    // }
}